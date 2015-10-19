package org.numisoft.oop1;

import java.util.Scanner;

public class Main {

	static Product[] productArray = new Product[10];

	public static void main(String[] args) {

		productArray = populateArray();

		/* Print available items */
		for (Product p : productArray) {
			System.out.println(p.UPC + " - " + p.name + " - " + p.manufacturer
					+ " - " + p.expiration + " - " + p.price);
		}

		/* Select items by product name */
		System.out.println("================");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input product name: ");
		String name = scanner.nextLine();
		getItemsByName(name);

		/* Select items by product name and target price */
		System.out.println("================");
		System.out.println("Input target price: ");
		getItemsByTargetPrice(name, scanner.nextDouble());

		/* Select items by expiration date */
		System.out.println("================");
		scanner = new Scanner(System.in);
		System.out.println("Input expiration date (YYYY.MM.DD): ");
		getItemsByExpirationDate(scanner.nextLine());

	}

	/* Populate array with 10 product items */
	public static Product[] populateArray() {
		System.out.println("Products available:");
		System.out.println("----------------");
		productArray[0] = new Product(1, "Chocolate", "012345678", "Nestle",
				4.50, "2015.12.12", 100);
		productArray[1] = new Product(2, "Chocolate", "45877895", "Nestle",
				5.50, "2015.11.20", 50);
		productArray[2] = new Product(3, "Cereal", "34457712", "Kellogg", 8.25,
				"2015.12.04", 50);
		productArray[3] = new Product(4, "Chocolate", "11245998", "Lindt",
				7.50, "2015.12.19", 70);
		productArray[4] = new Product(5, "Cereal", "43791546", "Cheerios",
				8.75, "2015.11.08", 100);
		productArray[5] = new Product(6, "Cereal", "23655179", "Kellogg", 6.25,
				"2015.12.12", 80);
		productArray[6] = new Product(7, "Milk", "02487732", "Walmart", 3.50,
				"2015.11.29", 75);
		productArray[7] = new Product(8, "Ketchup", "04789147", "Heinz", 3.00,
				"2015.12.30", 20);
		productArray[8] = new Product(9, "Milk", "99875473", "Happy farm",
				4.25, "2015.10.21", 100);
		productArray[9] = new Product(10, "Ketchup", "14671297", "Walmart",
				4.50, "2015.10.27", 90);
		return productArray;
	}

	/* Print items by product name */
	public static void getItemsByName(String name) {
		System.out.println("================");
		System.out.println(name + ":");
		System.out.println("----------------");
		for (Product p : productArray) {
			if (p.name.equalsIgnoreCase(name)) {
				System.out.println(p.UPC + " - " + p.name + " - "
						+ p.manufacturer + " - " + p.expiration + " - "
						+ p.price);
			}
		}
	}

	/* Print items with product name and target price */
	public static void getItemsByTargetPrice(String name, double price) {
		System.out.println("================");
		System.out.println(name + " with price below " + price + ":");
		System.out.println("----------------");
		for (Product p : productArray) {
			if (p.name.equalsIgnoreCase(name) && p.price <= price) {
				System.out.println(p.UPC + " - " + p.name + " - "
						+ p.manufacturer + " - " + p.expiration + " - "
						+ p.price);
			}
		}
	}

	/* Print items by expiration date */
	public static void getItemsByExpirationDate(String date) {
		System.out.println("================");
		System.out.println("Items with expiration date after " + date + ":");
		System.out.println("----------------");
		for (Product p : productArray) {
			int result = date.compareTo(p.expiration);
			if (result <= 0) {
				System.out.println(p.UPC + " - " + p.name + " - "
						+ p.manufacturer + " - " + p.expiration + " - "
						+ p.price);
			}
		}
	}
}
