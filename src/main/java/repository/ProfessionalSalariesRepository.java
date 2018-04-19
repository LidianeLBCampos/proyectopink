package repository;

import java.util.ArrayList;

import domain.ProfessionalSalaries;

public interface ProfessionalSalariesRepository {
	
	public void create(ProfessionalSalaries professionalSalaries);
	
	public ArrayList<ProfessionalSalaries> findByName(String name);
	
	public ProfessionalSalaries findAll();
	
	public void delete(ProfessionalSalaries professionalSalaries);
	
	public void update(ProfessionalSalaries professionalSalaries);

}
