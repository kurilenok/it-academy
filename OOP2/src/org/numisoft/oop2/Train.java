package org.numisoft.oop2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.numisoft.oop2.cars.Car;
import org.numisoft.oop2.cars.Kupe;
import org.numisoft.oop2.cars.Obschij;
import org.numisoft.oop2.cars.Platzkart;
import org.numisoft.oop2.cars.Sv;
import org.numisoft.oop2.locomotives.Elektrovoz;
import org.numisoft.oop2.locomotives.Locomotive;
import org.numisoft.oop2.locomotives.Teplovoz;

/**
 * This class describes train that consists of locomotive and several passenger
 * cars
 * */
public class Train {

	private Locomotive locomotive;
	private List<Car> cars = new ArrayList<Car>();
	private int maxCarNumber;
	private int totalPassengerNumber;
	private int totalBaggageNumber;

	/**
	 * This methods adds locomotive to the train
	 * */
	public void addLocomotive() {

		System.out.println("Input locomotive: ");
		System.out.println("t = Teplovoz  |  e = Electrovoz");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String inputLocomotive = scanner.next();
			if (inputLocomotive.equalsIgnoreCase("t")) {
				locomotive = new Teplovoz();
				break;
			}
			if (inputLocomotive.equalsIgnoreCase("e")) {
				locomotive = new Elektrovoz();
				break;
			}
		}
		setMaxCartNumber(locomotive.getMaxCarNumber());
		System.out.println("Locomotive added: "
				+ locomotive.getLocomotiveType());
		System.out.println("------------------------");
	}

	/**
	 * This method adds passenger cars to the train, max number of cars is set
	 * by locomotive type
	 * 
	 * */
	public void addCars() {

		System.out.println("Input cars, max " + this.getMaxCarNumber() + ": ");
		System.out
				.println("s = Sv  |  k = Kupe  |  p = Platzkart  |  o = Obschij");
		System.out.println("E.g.: sskkkpppooopppkk");
		Scanner scanner = new Scanner(System.in);

		String inputCars = scanner.nextLine().replaceAll("[^skpo]", "");

		if (inputCars.length() > getMaxCarNumber()) {
			inputCars = inputCars.substring(0, getMaxCarNumber());
		}

		char[] carSequence = inputCars.toCharArray();

		if (carSequence.length > 0) {
			System.out.println(carSequence.length + " passenger cars added: ");
		} else {
			System.out.println("Nothing to add!");
		}

		for (int i = 0; i < carSequence.length; i++) {
			switch (carSequence[i]) {
			case 's':
				System.out.println("Car No." + (i + 1) + " is SV");
				cars.add(new Sv(i + 1));
				break;
			case 'k':
				System.out.println("Car No." + (i + 1) + " is Kupe");
				cars.add(new Kupe(i + 1));
				break;
			case 'p':
				System.out.println("Car No." + (i + 1) + " is Platzkart");
				cars.add(new Platzkart(i + 1));
				break;
			case 'o':
				System.out.println("Car No." + (i + 1) + " is Obschij");
				cars.add(new Obschij(i + 1));
				break;
			}
		}
		System.out.println("------------------------");
	}

	/**
	 * This method returns total passenger number
	 * */
	public int getTotalPassangerNumber() {
		for (Car c : cars) {
			totalPassengerNumber += c.getPassengerNumber();
		}
		return totalPassengerNumber;
	}

	/**
	 * This method returns total baggage number
	 * */
	public int getTotalBaggageNumber() {
		for (Car c : cars) {
			totalBaggageNumber += c.getBaggageNumber();
		}
		return totalBaggageNumber;
	}

	/**
	 * This method sorts passenger cars by comfort level
	 * */
	public void sortCarsByComfortLevel() {
		System.out.println("------------------------");
		System.out.println("Sorted by comfort level:");
		Collections.sort(cars);
		for (Car c : cars) {
			System.out.println("Car No." + c.getCarNumber() + " is "
					+ c.getCartType() + " = Comfort level "
					+ c.getComfortLevel());
		}

	}

	/**
	 * This method selects cars by number of passengers
	 * */
	public void getCarsByPassangerNumber() {
		System.out.println("------------------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input MIN number of passengers per 1 car: ");
		int from = scanner.nextInt();
		System.out.println("Input MAX number of passengers per 1 car: ");
		int to = scanner.nextInt();

		Iterator<Car> cartsIterator = cars.iterator();
		System.out.println("Cars with number of passengers from " + from
				+ " to " + to + ":");
		while (cartsIterator.hasNext()) {
			Car c = cartsIterator.next();
			if (c.getPassengerNumber() >= from && c.getPassengerNumber() <= to) {
				System.out.println("Cat No." + c.getCarNumber() + " is "
						+ c.getCartType() + " = " + c.getPassengerNumber()
						+ " passengers");
			}
		}
	}

	public int getMaxCarNumber() {
		return maxCarNumber;
	}

	public void setMaxCartNumber(int maxCarNumber) {
		this.maxCarNumber = maxCarNumber;
	}
}
