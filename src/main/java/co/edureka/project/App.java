package co.edureka.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edureka.config.SpringMongoConfig;
import co.edureka.dao.MoviesDAO;
import co.edureka.dao.UsersDAO;
import co.edureka.model.Users;

public class App {
	public static void main(String[] args) {	
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");		
		UsersDAO dao = context.getBean("usersDAO", UsersDAO.class);
		Users user = new Users("vai2","vai2","vai2@gmail.com");
		dao.insertUser(user);
		//MoviesDAO mdao = context.getBean("moviesDAO", MoviesDAO.class);
	//	System.out.println(mdao.findAll().get(5).getTitle());
	}
}
