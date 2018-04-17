package repository.util;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import domain.ProfessionalSalaries;

public class Connection {
	private static final String HOSTNAME = "localhost";
	private static final String DATABASE_NAME = "professional-collections";
	private static final int PORT = 27017;

	private static MongoClient mongoClient;

	private static MongoDatabase getConnection() {
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		mongoClient = new MongoClient(new ServerAddress(HOSTNAME, PORT), MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
		return mongoClient.getDatabase(DATABASE_NAME);

	}

	public static MongoCollection<ProfessionalSalaries> getCollection(String collectionName) {
		return getConnection().getCollection(collectionName, ProfessionalSalaries.class);

	}

}
