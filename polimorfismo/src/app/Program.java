package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsoucerEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<Employee> listEmployees = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of employees: ");
		int numberEmployee = sc.nextInt();
		for (int i = 1; i <= numberEmployee; i++) {

			System.out.println("Employee #" + i + "data");
			System.out.println("Outsourced (y/n)?");
			char typeEmployee = sc.next().charAt(0);
			System.out.println("Name:");
			String name = sc.next();
			System.out.println("Hours");
			int hours = sc.nextInt();
			System.out.println("Value per hour:");
			double valuePerHours = sc.nextDouble();
			if (typeEmployee == 'y') {
				System.out.println("Additional charge:");
				double additonalCharge = sc.nextDouble();
				Employee employee = new OutsoucerEmployee(name, hours, valuePerHours, additonalCharge);
				listEmployees.add(employee);
			} else {
				Employee employee = new Employee(name, hours, valuePerHours);

				listEmployees.add(employee);
			}

		}
		System.out.println();
		System.out.println("PAYMENTS");
		for (Employee employee : listEmployees) {
			System.out.println(employee.getName() + "-" + String.format("%.2f", employee.payment()));
		}
		sc.close();

	}
}
