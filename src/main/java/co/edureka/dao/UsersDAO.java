package co.edureka.dao;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import co.edureka.config.SpringMongoConfig;
import co.edureka.model.Users;

public class UsersDAO {
	private ApplicationContext context;
	private MongoOperations mongoOperations;
	
	public UsersDAO() {
		this.context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		this.mongoOperations = context.getBean("mongoTemplate", MongoOperations.class);
	}
	
	public void insertUser(Users user) {
		mongoOperations.save(user);
	}
	
	public Users findUser(String email, String password) {
		Query query = new Query(Criteria.where("email").is(email).and("password").is(password));
		return mongoOperations.findOne(query, Users.class);
	}
	
	public void updatePassword(String email, String password, String newPassword){
		Query query = new Query(Criteria.where("email").is(email).and("password").is(password));
		mongoOperations.updateFirst(query, Update.update("password", newPassword), Users.class);
	}
	
}
