package service.impl;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;

import com.google.common.base.Strings;

import domain.ProfessionalSalaries;
import repository.ProfessionalSalariesRepository;
import repository.impl.ProfessionalSalariesRepositoryImpl;
import service.ProfessionalSalariesService;

public class ProfessionalSalariesServiceImpl implements ProfessionalSalariesService {
	private final static int MINIMAL_YEAR = 2014;

	ProfessionalSalariesRepository repo = new ProfessionalSalariesRepositoryImpl();

	@Override
	public List<ProfessionalSalaries> getProfessionalSalariesByName(String name) {
		if (Strings.isNullOrEmpty(name)) {
			throw new IllegalArgumentException("El parametro nombre debe ser rellenado");
		}

		return IteratorUtils.toList(repo.findByName(name));

	}

	@Override
	public void deleteByNameAndYear(String name, int year) {
		validateNameAndYear(name, year);

		ProfessionalSalaries ps = repo.findOneByNameAndYear(name, year);
		if (ps != null) {
			repo.delete(ps);
		}

	}

	@Override
	public ProfessionalSalaries getOneByNameAndYear(String name, int year) {
		validateNameAndYear(name, year);
		return repo.findOneByNameAndYear(name, year);
	}

	@Override
	public void updateOne(ProfessionalSalaries oldProfSal, ProfessionalSalaries newProfSal) {
		if (newProfSal == null || oldProfSal == null) {
			throw new IllegalArgumentException("El parametro valor no ha sido rellenado");
		}

		repo.update(oldProfSal, newProfSal);

	}

	private void validateNameAndYear(String name, int year) {
		if (Strings.isNullOrEmpty(name)) {
			throw new IllegalArgumentException("El parametro nombre debe ser rellenado");
		}

		if (year < MINIMAL_YEAR) {
			throw new IllegalArgumentException("El parametro nombre debe ser rellenado");
		}
	}

	@Override
	public void createOne(ProfessionalSalaries newProfSal) {
		if (newProfSal == null) {
			throw new IllegalArgumentException("Verificar se todos los datos estan rellenados");
		}
		repo.create(newProfSal);

	}

}
