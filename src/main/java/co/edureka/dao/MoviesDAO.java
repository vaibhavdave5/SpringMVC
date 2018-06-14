package co.edureka.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import co.edureka.config.SpringMongoConfig;
import co.edureka.model.Movies;

public class MoviesDAO {

	private ApplicationContext context;
	private MongoOperations mongoOperations;
	
	public MoviesDAO() {
		this.context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		this.mongoOperations = context.getBean("mongoTemplate", MongoOperations.class);
	}
	
	public List<Movies> findCurrentSet(int skip) {
		return mongoOperations.find(new Query().skip(skip*12).limit(12),Movies.class);
	}
	
	public List<Movies> findAll() {
		return mongoOperations.find(new Query(),Movies.class);
	}
}
