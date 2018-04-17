package domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonPropertyOrder({ "year", "name", "level", "id", "avgSalary", "employees" })

public class ProfessionalSalaries {
	public static final String COLLECTION_NAME = "professional_salaries";
	private String id;
	@JsonDeserialize(contentAs = Integer.class)
	private int year;
	private String name;
	private int level;
	private double avgSalary;
	private int employees;
	
	public ProfessionalSalaries() {
		super();
	}

	public ProfessionalSalaries(String id, int year, String name, int level, double avgSalary, int employees) {
		super();
		this.year = year;
		this.name = name;
		this.level = level;
		this.id = id;
		this.avgSalary = avgSalary;
		this.employees = employees;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getAvgSalary() {
		return avgSalary;
	}

	public void setAvgSalary(double avgSalary) {
		this.avgSalary = avgSalary;
	}

	public int getEmployees() {
		return employees;
	}

	public void setEmployees(int employees) {
		this.employees = employees;
	}

}
