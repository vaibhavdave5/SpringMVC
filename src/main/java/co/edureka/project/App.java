package co.edureka.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import co.edureka.config.SpringMongoConfig;
import co.edureka.model.Users;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperations = context.getBean("mongoTemplate", MongoOperations.class);
		Users user = new Users("vai","vai","vai@gmail.com");
//		mongoOperations.save(user);
		
		// query to search user
		Query searchUserQuery = new Query(Criteria.where("name").is("vai"));

		// find the saved user again.
		Users savedUser = mongoOperations.findOne(searchUserQuery, Users.class);
		System.out.println("2. find - savedUser : " + savedUser.getEmail());

	}

}
