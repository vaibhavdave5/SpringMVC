package co.edureka.dao;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;

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
	
	public List<Movies> findbyText(String search) {
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matching(search);
		Query query = TextQuery.queryText(criteria);
		
		return mongoOperations.find(query,Movies.class);
	}
	
	public Movies findbyId(String id) {
		return mongoOperations.find(new Query(Criteria.where("_id").is(new ObjectId(id))),Movies.class).get(0);
	}
}
