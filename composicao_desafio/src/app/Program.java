package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
//		CLIENTE
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birth date (DD/MM/YYYY):");

		Date bd = sdf.parse(sc.next());
		Client client = new Client(email, name, bd);
//		ORDER
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		String status = sc.next();
		System.out.println("How many items to this order?");
		int items = sc.nextInt();

		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		for (int i = 1; i < items; i++) {
//product
			System.out.println("Enter #" + i + "item data:");
			System.out.println("Product name: ");
			String productName = sc.next();
			System.out.println("Product price: ");
			Double price = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer quantity = sc.nextInt();
			Product product = new Product(productName, price);

			OrderItem oi = new OrderItem(quantity, price, product);
			order.addItem(oi);
		}

		sc.close();
	}

}
