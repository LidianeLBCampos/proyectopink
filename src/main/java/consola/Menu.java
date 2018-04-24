package consola;

import java.util.Scanner;

import domain.ProfessionalSalaries;
import service.ProfessionalSalariesService;
import service.impl.ProfessionalSalariesServiceImpl;

public class Menu {
	public static int menuOption;
	public static Scanner input = new Scanner(System.in);
	private static ProfessionalSalariesService service = new ProfessionalSalariesServiceImpl();

	public static void main(String[] args) throws CloneNotSupportedException {

		do {
			System.out.println("------------------------------------------------------");
			System.out.println("Salarios por Profesiones");
			System.out.println("(1) Buscar Profesion por Nombre");
			System.out.println("(2) Borrar Profesion");
			System.out.println("(3) Update Profesion");
			System.out.println("(4) Crear un Registro");
			System.out.println("(0) Para Salir");
			System.out.print("Pulse la opción deseada: ");
			menuOption = input.nextInt();
			input.nextLine();
			switch (menuOption) {
			case 1:
				System.out.print("Introduzca el nombre de la profesión: ");
				String name = input.nextLine();
				service.getProfessionalSalariesByName(name).forEach(System.out::println);
				break;
			case 2:
				System.out.println("Introduzca el nombre de la profesión que desea borar");
				String nameDelete = input.nextLine();
				System.out.println("Introduzca el año que desea borrar el dato");
				int yearDelete = input.nextInt();
				service.deleteByNameAndYear(nameDelete, yearDelete);
				break;
			case 3:
				System.out.print("Introduzca el nombre de la profesión que desea cambiar:");
				String nameUpdate = input.nextLine();
				System.out.print("Introduzca el año del registro que desea cambiar:");
				int year = input.nextInt();
				ProfessionalSalaries ps = service.getOneByNameAndYear(nameUpdate, year);
				System.out.println(ps);
				ProfessionalSalaries psClone = ps.clone();
				System.out.println("Informe el nuevo valor de la media salarial");
				double newAvgSal = input.nextDouble();
				psClone.setAvgSalary(newAvgSal);
				service.updateOne(ps, psClone);
				break;

			case 4:
				System.out.println("Introduzca los datos");
				System.out.println("Introduzca el año");
				int yearCreate = input.nextInt();
				System.out.println("Introduzca el nombre de la profesión");
				String nameCreate = input.next();
				System.out.println("Introduzca nivel");
				int level = input.nextInt();
				System.out.println("Introduzca la media anual del Salario");
				double avgSalary = input.nextDouble();
				System.out.println("Introduzca el numero de empleados registrados en este sector");
				int employees = input.nextInt();
				service.createOne(new ProfessionalSalaries(yearCreate, nameCreate, level, avgSalary, employees));
				break;
			default:
				System.out.println("Seleccione una de las opciones");
			}

		} while (menuOption != 0);

	}

}
