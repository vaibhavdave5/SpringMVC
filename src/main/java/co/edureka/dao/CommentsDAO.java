package co.edureka.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import co.edureka.config.SpringMongoConfig;
import co.edureka.model.Comments;
import co.edureka.model.Movies;

public class CommentsDAO {

	private ApplicationContext context;
	private MongoOperations mongoOperations;
	
	public CommentsDAO() {
		this.context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		this.mongoOperations = context.getBean("mongoTemplate", MongoOperations.class);
	}
	
	public List<Comments> findCommentById(String id) {
		return mongoOperations.find(new Query(Criteria.where("movie_id").is(new ObjectId(id))),Comments.class);
	}
}
