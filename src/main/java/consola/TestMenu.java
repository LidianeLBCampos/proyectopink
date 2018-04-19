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
			System.out.println("(0) Para Salir");
			System.out.println("Pulse la opción deseada");
			menuOption = input.nextInt();
			System.out.println("------------------------------------------------------");

			switch (menuOption) {
			case 1:
				System.out.println("Introduzca el nombre de la profesión");
				String name= input.next();
				List<ProfessionalSalaries> list = repo.findByName(name);
				for (ProfessionalSalaries professionalSalaries : list) {
					System.out.println(list);
				}
				break;
			case 2:
				
				

			}

		}

	}
}
