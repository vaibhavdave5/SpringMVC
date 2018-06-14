package co.edureka.project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import co.edureka.dao.CommentsDAO;
import co.edureka.dao.MoviesDAO;
import co.edureka.dao.UsersDAO;
import co.edureka.model.Movies;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private ApplicationContext context;		
	private UsersDAO dao;
	private MoviesDAO mdao;
	private int size = 46014;
	
	public HomeController() {
		this.context = new ClassPathXmlApplicationContext("SpringConfig.xml");		
		this.dao = context.getBean("usersDAO", UsersDAO.class);
		this.mdao = context.getBean("moviesDAO", MoviesDAO.class);
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
	
}
