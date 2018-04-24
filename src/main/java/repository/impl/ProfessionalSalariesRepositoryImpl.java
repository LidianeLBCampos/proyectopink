package repository.impl;

import java.util.Iterator;

import com.mongodb.client.MongoCollection;
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

	public Iterator<ProfessionalSalaries> findByName(String name) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		return collection.find(Filters.eq("name", name)).iterator();

	}

	@Override
	public ProfessionalSalaries findOneByNameAndYear(String name, int year) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		return collection.find(Filters.and(Filters.eq("name", name), Filters.eq("year", year))).first();
	}

	public void delete(ProfessionalSalaries professionalSalaries) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		collection.deleteOne(Filters.eq("_id", professionalSalaries.getId()));
	}

	public void update(ProfessionalSalaries oldProfSal, ProfessionalSalaries newProfSal) {
		MongoCollection<ProfessionalSalaries> collection = Connection
				.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		collection.findOneAndReplace(Filters.eq("_id", oldProfSal.getId()), newProfSal);

	}

}
