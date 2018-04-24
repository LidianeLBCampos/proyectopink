package service;

import java.util.List;

import domain.ProfessionalSalaries;

public interface ProfessionalSalariesService {
	
	List<ProfessionalSalaries> getProfessionalSalariesByName(String name);
	
	void deleteByNameAndYear(String name, int year);
	
	ProfessionalSalaries getOneByNameAndYear(String name, int year);
	
	void updateOne(ProfessionalSalaries oldProfSal, ProfessionalSalaries newProfSal);
	
	void createOne(ProfessionalSalaries newProfSal);

}
