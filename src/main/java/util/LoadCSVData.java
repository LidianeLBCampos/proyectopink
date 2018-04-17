package util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import domain.ProfessionalSalaries;
import repository.ProfessionalSalariesRepository;
import repository.impl.ProfessionalSalariesRepositoryImpl;

public class LoadCSVData {

	public List<ProfessionalSalaries> loadFromCSV() throws JsonProcessingException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File f = new File(classLoader.getResource("Data.csv").getFile());
		MappingIterator<ProfessionalSalaries> profIter = new CsvMapper()
				.readerWithTypedSchemaFor(ProfessionalSalaries.class).readValues(f);
		return profIter.readAll();
	}
	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		LoadCSVData load = new LoadCSVData();
		List<ProfessionalSalaries> professionals = load.loadFromCSV();
		ProfessionalSalariesRepository repo = new ProfessionalSalariesRepositoryImpl();
		for(ProfessionalSalaries p : professionals) {
			repo.create(p);
		}
	}

}
