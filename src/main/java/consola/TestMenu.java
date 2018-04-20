package consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import domain.ProfessionalSalaries;
import repository.impl.ProfessionalSalariesRepositoryImpl;
import repository.util.Connection;

public class TestMenu {
	public static int menuOption = 1;
	public static Scanner input = new Scanner(System.in);
	public static ProfessionalSalariesRepositoryImpl repo = new ProfessionalSalariesRepositoryImpl();
	public static MongoCollection<ProfessionalSalaries> collection = Connection
			.getCollection(ProfessionalSalaries.COLLECTION_NAME);

	public static void main(String[] args) {

		while (menuOption != 0) {
			System.out.println("------------------------------------------------------");
			System.out.println("Salarios por Profesiones");
			System.out.println("(1) Buscar Profesion por Nombre");
			System.out.println("(2) Borrar Profesion");
			System.out.println("(3) Update Profesion");
			System.out.println("(4) Crear un Registro");
			System.out.println("(0) Para Salir");
			System.out.println("Pulse la opción deseada");
			menuOption = input.nextInt();
			System.out.println("------------------------------------------------------");

			switch (menuOption) {
			case 1:
				System.out.println("Introduzca el nombre de la profesión");
				String name = input.next();
				repo.findByName(name);
			
				break;
			case 2:
				System.out.println("Introduzca el nombre de la profesión que desea borar");
				String nameDelete = input.next();
				repo.findByName(nameDelete);
			
				break;
			case 3:
				System.out.println("Introduzca el nombre de la profesión que desea cambiar");
				String nameUpdate = input.next();
			//	repo.update(repo.findByName(nameUpdate), new ProfessionalSalaries(2001, "testUpdate", 3, 3000.00, 30));
				break;
				
			case 4:
				System.out.println("Introduzca los datos");
				System.out.println("Introduzca el año");
				int year = input.nextInt();
				System.out.println("Introduzca el nombre de la profesión");
				String nameCreate = input.next();
				System.out.println("Introduzca nivel");
				int level = input.nextInt();
				System.out.println("Introduzca la media anual del Salario");
				double avgSalary = input.nextDouble();
				System.out.println("Introduzca el numero de empleados registrados en este sector");
				int employees = input.nextInt();
				repo.create(new ProfessionalSalaries(year, nameCreate, level, avgSalary, employees));
				break;
				default:
					System.out.println("Seleccione una de las opciones");
			}

		}

	}
}
