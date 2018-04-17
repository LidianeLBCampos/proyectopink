package repository;

import domain.ProfessionalSalaries;

public interface ProfessionalSalariesRepository {
	
	public void create(ProfessionalSalaries professionalSalaries);
	
	public ProfessionalSalaries findByName(String name);
	
	public void delete(ProfessionalSalaries professionalSalaries);
	
	public void update(ProfessionalSalaries professionalSalaries);

}
