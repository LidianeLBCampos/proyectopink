package repository.impl;

import com.mongodb.client.MongoCollection;

import domain.ProfessionalSalaries;
import repository.ProfessionalSalariesRepository;
import repository.util.Connection;

public class ProfessionalSalariesRepositoryImpl implements ProfessionalSalariesRepository {

	public void create(ProfessionalSalaries professionalSalaries) {
		MongoCollection<ProfessionalSalaries> collection 
			= Connection.getCollection(ProfessionalSalaries.COLLECTION_NAME);
		collection.insertOne(professionalSalaries);
	}

	public ProfessionalSalaries findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(ProfessionalSalaries professionalSalaries) {
		// TODO Auto-generated method stub

	}

	public void update(ProfessionalSalaries professionalSalaries) {
		// TODO Auto-generated method stub

	}

}
