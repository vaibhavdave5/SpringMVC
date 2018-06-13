package co.edureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import co.edureka.dao.UsersDAO;

public class SpringMongoConfig extends AbstractMongoConfiguration{

	@Override
	@Bean
	public MongoClient mongoClient() {
		MongoClientURI uri = new MongoClientURI
				("mongodb+srv://analytics:analytics-password@mflix-ui0uw.mongodb.net/test?retryWrites=true");					    		
		return new MongoClient(uri);
	}

	@Override
	protected String getDatabaseName() {
		return "mflix";
	}
	
}
