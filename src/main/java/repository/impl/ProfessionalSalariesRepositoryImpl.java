package repository.impl;

import java.io.LineNumberInputStream;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import domain.ProfessionalSalaries;
import repository.ProfessionalSalariesRepository;
import repository.util.Connection;

public class ProfessionalSalariesRepositoryImpl implements ProfessionalSalariesRepository {

	public void create(ProfessionalSalaries professionalSalaries) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		collection.insertOne(professionalSalaries);
	}

	public void findByName(String name) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		MongoCollection<ProfessionalSalaries> proSal = collection.withDocumentClass(ProfessionalSalaries.class);
		MongoCursor<ProfessionalSalaries> cursor = proSal.find(Filters.eq("name", "Machine feeders & offbearers"))
				.iterator();

		while (cursor.hasNext()) {
			System.out.println(cursor.next().toString());
		}
	}

	public void delete(ProfessionalSalaries professionalSalaries) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		collection.deleteOne(Filters.eq(professionalSalaries));
	}

	public void update(ProfessionalSalaries professionalSalaries, ProfessionalSalaries newProf) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		collection.findOneAndReplace(Filters.eq(professionalSalaries), newProf);

	}

	@Override
	public void update(ProfessionalSalaries professionalSalaries) {
		// TODO Auto-generated method stub

	}
}