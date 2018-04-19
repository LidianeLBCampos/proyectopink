package repository.impl;

import org.bson.BSON;
import org.bson.conversions.Bson;

import com.mongodb.async.SingleResultCallback;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates.*;

import domain.ProfessionalSalaries;
import repository.ProfessionalSalariesRepository;
import repository.util.Connection;

public class ProfessionalSalariesRepositoryImpl implements ProfessionalSalariesRepository {

	public void create(ProfessionalSalaries professionalSalaries) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		collection.insertOne(professionalSalaries);
	}

	public ProfessionalSalaries findByName(String name) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		return collection.find(Filters.eq("name", name)).first();
	}

	public void delete(ProfessionalSalaries professionalSalaries) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		collection.deleteOne(Filters.eq(professionalSalaries));
	}

	public void update(ProfessionalSalaries professionalSalaries) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		collection.findOneAndReplace((Bson) professionalSalaries, new ProfessionalSalaries());

	}

}
