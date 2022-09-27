package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy"); //instanciando e importando formato de data para
		//ser usado na linha 41.
		
		System.out.print("Enter departament name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary, new Departament(departmentName));
		// Instanciado um novo objeto do tipo Worker, os dados deste objeto são: o nome que eu digitei + uma instância
		// de WorkerLevel no valor que eu digitei + o valor do salario base que eu digitei, associado a a este objeto 
		// vai ter um outro objeto do tipo departamento e o nome deste departamento é o nome que eu tambem digitei.
		
		System.out.println("How many contrats to this worker? ");
		int n = sc.nextInt();
		
		for (int i = 1; i<= n; i++) {
			System.out.println("Enter contract #" + i + " data");
			System.out.print("Dete (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Dete (Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours); 
			// instanciando e importando HourContract.
			worker.addContract(contract); // Associando o contrato com o trabalhador
			//criamos os N contratos, adicionando na lista, que estada instanciada na classe Worker, 
			//lina 17 e associando os mesmos contratos e lista ao trabalhador.
		}
		
		System.out.println();
		System.out.print("Enter month end year to calculate incom (MM/YYYY): ");
		String monthAndYear = sc.next();
		
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		// Recortando a string, convertendo para inteiro e salvando em uma variável chamada month.
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartament().getName());
		//worker.getDepartament()-> Acessa o Objeto Depatament e através dele pego o nome dele com .getName().
		System.out.println("Income for: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));	
		
		
		sc.close();

	}

}
