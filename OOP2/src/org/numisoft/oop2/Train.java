package org.numisoft.oop2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
public class Train implements Serializable {

	private Locomotive locomotive;
	private List<Car> cars = new ArrayList<Car>();
	private int maxCarNumber;
	private int totalPassengerNumber;
	private int totalBaggageNumber;

	/**
	 * This methods adds locomotive to the train
	 * */
	public void addLocomotive() {

		System.out.println(Main.rb.getString("input_locomotive"));
		System.out.println(Main.rb.getString("locomotive_types"));

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String inputLocomotive = scanner.next();
			if (inputLocomotive.equalsIgnoreCase("t")) {
				locomotive = new Teplovoz();
				Main.logger.log("User added Teplovoz as locomotive");
				break;
			}
			if (inputLocomotive.equalsIgnoreCase("e")) {
				locomotive = new Elektrovoz();
				Main.logger.log("User added Electrovoz as locomotive");
				break;
			}
		}
		setMaxCartNumber(locomotive.getMaxCarNumber());

		System.out.println(Main.rb.getString("locomotive_added") + " "
				+ locomotive.getLocomotiveType());
		System.out.println("------------------------");
	}

	/**
	 * This method adds passenger cars to the train, max number of cars is set
	 * by locomotive type
	 * 
	 * */
	public void addCars() {

		System.out.println(Main.rb.getString("input_cars") + this.getMaxCarNumber() + ": ");
		System.out.println(Main.rb.getString("cars_types"));
		System.out.println(Main.rb.getString("cars_example"));
		Scanner scanner = new Scanner(System.in);

		String inputCars = scanner.nextLine().replaceAll("[^skpo]", "");

		if (inputCars.length() > getMaxCarNumber()) {
			inputCars = inputCars.substring(0, getMaxCarNumber());
		}

		char[] carSequence = inputCars.toCharArray();

		if (carSequence.length > 0) {
			System.out.println("------------------------");
			System.out.println(carSequence.length + " " + Main.rb.getString("cars_added"));
			Main.logger.log("User added the following cars: " + inputCars);
		} else {
			System.out.println(Main.rb.getString("cars_not_added"));
			Main.logger.log("User added no cars");
		}

		for (int i = 0; i < carSequence.length; i++) {
			switch (carSequence[i]) {
			case 's':
				System.out.println(Main.rb.getString("car_number") + (i + 1) + " "
						+ Main.rb.getString("car_is_SV"));
				cars.add(new Sv(i + 1));
				break;
			case 'k':
				System.out.println(Main.rb.getString("car_number") + (i + 1) + " "
						+ Main.rb.getString("car_is_kupe"));
				cars.add(new Kupe(i + 1));
				break;
			case 'p':
				System.out.println(Main.rb.getString("car_number") + (i + 1) + " "
						+ Main.rb.getString("car_is_platzkart"));
				cars.add(new Platzkart(i + 1));
				break;
			case 'o':
				System.out.println(Main.rb.getString("car_number") + (i + 1) + " "
						+ Main.rb.getString("car_is_obschij"));
				cars.add(new Obschij(i + 1));
				break;
			}
		}
		System.out.println("------------------------");
	}

	/** This method lists all cars added to train */
	public void showCars() {
		for (Car c : this.cars) {
			switch (c.getCartType()) {
			case "SV":
				System.out.println(Main.rb.getString("car_number") + c.getCarNumber() + " "
						+ Main.rb.getString("car_is_SV"));
				break;
			case "Kupe":
				System.out.println(Main.rb.getString("car_number") + c.getCarNumber() + " "
						+ Main.rb.getString("car_is_kupe"));
				break;
			case "Platzkart":
				System.out.println(Main.rb.getString("car_number") + c.getCarNumber() + " "
						+ Main.rb.getString("car_is_platzkart"));
				break;
			case "Obschij":
				System.out.println(Main.rb.getString("car_number") + c.getCarNumber() + " "
						+ Main.rb.getString("car_is_obschij"));
				break;
			}
		}
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
		System.out.println(Main.rb.getString("sort_by_comfort"));
		Collections.sort(cars);
		for (Car c : cars) {
			System.out.println(Main.rb.getString("car_number") + c.getCarNumber() + " is "
					+ c.getCartType() + " " + Main.rb.getString("comfort_level") + " "
					+ c.getComfortLevel());
		}

	}

	/**
	 * This method selects cars by number of passengers
	 * */
	public void getCarsByPassangerNumber() {
		System.out.println("------------------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println(Main.rb.getString("input_min"));
		int from = scanner.nextInt();
		System.out.println(Main.rb.getString("input_max"));
		int to = scanner.nextInt();

		Iterator<Car> cartsIterator = cars.iterator();
		System.out.println("------------------------");

		System.out.println(Main.rb.getString("cars_with") + " " + from + "-" + to + " "
				+ Main.rb.getString("passengers") + ":");

		Main.logger.log("User selected cars with passenger number from " + from + " to " + to);
		while (cartsIterator.hasNext()) {
			Car c = cartsIterator.next();
			if (c.getPassengerNumber() >= from && c.getPassengerNumber() <= to) {
				System.out.println(Main.rb.getString("car_number") + c.getCarNumber() + " "
						+ Main.rb.getString("is") + " " + c.getCartType() + " = "
						+ c.getPassengerNumber() + " " + Main.rb.getString("passengers"));
			}
		}
	}

	public int getMaxCarNumber() {
		return maxCarNumber;
	}

	public void setMaxCartNumber(int maxCarNumber) {
		this.maxCarNumber = maxCarNumber;
	}

	/** This method writes train to file */
	public void writeTrain() {

		System.out.println(Main.rb.getString("write_to"));

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input = scanner.next();
			if (input.equalsIgnoreCase("n")) {
				Main.logger.log("User refused to serialize train to file");
				break;
			}
			if (input.equalsIgnoreCase("y")) {
				try {
					FileOutputStream fos = new FileOutputStream("./train.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(this);
					oos.close();
					fos.close();
					System.out.println(Main.rb.getString("written"));
					Main.logger.log("User serialized train to file");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	/** This method reads train from file */
	public static Train readTrain() {

		Train train = new Train();
		System.out.println("------------------------");
		System.out.println(Main.rb.getString("read_from"));

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input = scanner.next();
			if (input.equalsIgnoreCase("n")) {
				Main.logger.log("User refused to deserialize train from file");
				break;
			}
			if (input.equalsIgnoreCase("y")) {
				try {
					FileInputStream fileIn = new FileInputStream("./train.ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					train = (Train) in.readObject();
					in.close();
					fileIn.close();
					System.out.println("------------------------");
					System.out.println(Main.rb.getString("from_file"));
					Main.logger.log("User deserialized train from file");
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		return train;
	}

	public Locomotive getLocomotive() {
		return locomotive;
	}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();

		result.append(Main.rb.getString("train_consists") + " ");
		result.append(this.getLocomotive().getLocomotiveType() + " ");
		result.append(Main.rb.getString("and") + " ");
		result.append(this.cars.size() + " " + Main.rb.getString("cars"));
		return result.toString();

	}

}
