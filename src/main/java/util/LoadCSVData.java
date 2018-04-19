package util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import domain.ProfessionalSalaries;
import repository.ProfessionalSalariesRepository;
import repository.impl.ProfessionalSalariesRepositoryImpl;

public class LoadCSVData {

	ClassLoader classLoader = getClass().getClassLoader();

	public List<ProfessionalSalaries> loadFromCSV() throws IOException {
		final List<ProfessionalSalaries> professionals = new ArrayList<>();

		Reader in = new FileReader(classLoader.getResource("Data.csv").getPath());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT
				.withHeader("year", "name", "level", "id", "avgSalary", "employees").withFirstRecordAsHeader()
				.parse(in);
		
		for (CSVRecord csv : records) {
			professionals.add(
					new ProfessionalSalaries(csv.get("id"), //
							Integer.parseInt(csv.get("year")),
					csv.get("name"), Integer.parseInt(csv.get("level")), Double.parseDouble(csv.get("avgSalary")),
					Integer.parseInt(csv.get("employees"))));
	    }

		

		return professionals;

	}

	public static void main(String[] args) throws IOException {
		LoadCSVData load = new LoadCSVData();
		List<ProfessionalSalaries> professionals = load.loadFromCSV();
		ProfessionalSalariesRepository repo = new ProfessionalSalariesRepositoryImpl();
		for (ProfessionalSalaries p : professionals) {
			repo.create(p);
		}
	}

}
