package co.edureka.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import co.edureka.config.SpringMongoConfig;
import co.edureka.dao.UsersDAO;
import co.edureka.model.Users;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		ApplicationContext xmlContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
		UsersDAO dao = xmlContext.getBean("usersDAO",UsersDAO.class);
		
		Users user = new Users("vai2","vai2","vai2@gmail.com");
		dao.insertUser(user);
//		
//		// query to search user
//		Query searchUserQuery = new Query(Criteria.where("name").is("vai"));
//
//		// find the saved user again.
//		Users savedUser = mongoOperations.findOne(searchUserQuery, Users.class);
//		System.out.println("2. find - savedUser : " + savedUser.getEmail());

	}

}
