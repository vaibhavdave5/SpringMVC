package co.edureka.project;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import co.edureka.dao.CommentsDAO;
import co.edureka.dao.MoviesDAO;
import co.edureka.dao.UsersDAO;
import co.edureka.model.Movies;
import co.edureka.model.Users;
import co.edureka.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private ApplicationContext context;		
	private UsersDAO dao;
	private MoviesDAO mdao;
	private UserService userService;
	private int size = 46014;
	
	
	public HomeController() {
		this.context = new ClassPathXmlApplicationContext("SpringConfig.xml");		
		this.dao = context.getBean("usersDAO", UsersDAO.class);
		this.mdao = context.getBean("moviesDAO", MoviesDAO.class);
		this.userService = context.getBean("userService", UserService.class);
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale); 
		List<Movies> movies = mdao.findCurrentSet(0);
		model.addAttribute("listOfMovies", movies);
		model.addAttribute("totalCount", 46014);
		model.addAttribute("currentPage", 1);
	//	System.out.println(mdao.findAll().size()); // 46014
		return "home";
	}
	
	
	@RequestMapping(value = "/nav", params="id", method = RequestMethod.GET)
    public String homeWithPagination(@RequestParam("id") int id, Model model) {
		if(id<0) {
			id=0;
		}
		if(id>size) {
			id=size;
		}
		List<Movies> movies = mdao.findCurrentSet(id);
		model.addAttribute("listOfMovies", movies);
		model.addAttribute("currentPage", id);
		return "home";
    }
	
	@RequestMapping(value = "/view", params="id", method = RequestMethod.GET)
    public String view(@RequestParam("id") String id, Model model) {
		Movies movie = mdao.findbyId(id);
		model.addAttribute("movie", movie);
		model.addAttribute("comments", new CommentsDAO().findCommentById(id));
		return "view";
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpPage(Locale locale, Model model) {
		model.addAttribute("userForm", new Users());
		return "signup";
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userForm") Users user, 
    					   BindingResult result, Model model,
    					   final RedirectAttributes redirectAttributes) {
		System.out.println(user.toString());
		userService.saveOrUpdate(user);
		return "home";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String enterLogin(Locale locale, Model model) {
		model.addAttribute("loginForm", new Users());
		return "login";
    }
	
	@RequestMapping(value = "/loggedIn", method = RequestMethod.POST)
    public String getUser(@ModelAttribute("loginForm") Users user, 
    					   BindingResult result, Model model,
    					   final RedirectAttributes redirectAttributes) {
		Users loggedInUser = userService.getUser(user.getEmail(), user.getPassword());
		System.out.println(loggedInUser.getName());
		return "home";
    }
	
	
	
}
