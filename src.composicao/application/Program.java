package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

//Ler os dados de um trabalhador com N contrator
//(nao fornecido pelo usuario). Depois, solicita do usuario
//um mes e mostrar qual foi o salario do funcionario nesse mes


public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		//Instanciei um novo objeto do tipo worker, os dados desse objeto é o nome que eu digitei
		// Uma instancia de workerLevel no valor que eu digitei
		// e o valor de salario base que eu digitei, associado a esse objeto
		// vai ter outro objeto do tipo departamento, que vai ser o nome que eu digitei
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYY");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per Hour");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (Hours)");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		};
		
		//armazenei mes e ano em uma variavel, e depois separei ela por mes e ano
		System.out.println("");
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		//Em Java, o método parseInt() é usado para converter uma representação de string de um número em um valor numérico do tipo int
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		
		
		sc.close();
		
		
	}
	
	
}
