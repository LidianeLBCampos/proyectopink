package repository;

import java.util.Iterator;

import domain.ProfessionalSalaries;

public interface ProfessionalSalariesRepository {

	public void create(ProfessionalSalaries professionalSalaries);

	public Iterator<ProfessionalSalaries> findByName(String name);

	public ProfessionalSalaries findOneByNameAndYear(String name, int year);

	public void delete(ProfessionalSalaries professionalSalaries);

	public void update(ProfessionalSalaries oldProfSal, ProfessionalSalaries newProfSal);

}
