package org.numisoft.oop2;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * This class is entry point to application
 * */
public class Main {

	public static ResourceBundle rb;
	public static Logger logger = Logger.getInstance();

	public static void main(String[] args) {

		/* Selecting locale */
		System.out.println("Select language | Выберите язык:");
		System.out.println("1 = English  |  2 = Русский");
		Scanner scanner = new Scanner(System.in);
		Locale l;
		while (true) {
			String selectLocale = scanner.next();
			if (selectLocale.equalsIgnoreCase("1")) {
				l = new Locale("en", "US");
				logger.log("User selected EN locale");
				break;
			}
			if (selectLocale.equalsIgnoreCase("2")) {
				l = new Locale("ru", "RU");
				logger.log("User selected RU locale");
				break;
			}
		}
		rb = ResourceBundle.getBundle("org.numisoft.oop2.i18n/strings", l);

		Train train = new Train();

		/* Adding locomotive to the train */
		train.addLocomotive();

		/* Adding cars to the train */
		train.addCars();

		/* Writing train to file */
		train.writeTrain();

		/* Calculating total passenger number */
		System.out.println("------------------------");
		System.out
				.println(rb.getString("total_passengers") + " " + train.getTotalPassangerNumber());

		/* Calculating total baggage number */
		System.out.println("------------------------");
		System.out.println(rb.getString("total_baggage") + " " + train.getTotalBaggageNumber());

		/* Selecting cars by passenger number */
		train.getCarsByPassangerNumber();

		/* Sorting cars by comfort level */
		train.sortCarsByComfortLevel();

		/* Reading train from file */
		Train train2 = Train.readTrain();

		if (train2.getTotalPassangerNumber() == 0) {
			System.out.println("------------------------");
			System.out.println("- Add comments -");
		} else {
			System.out.println(rb.getString("locomotive_is") + " "
					+ train2.getLocomotive().getLocomotiveType());
			train2.showCars();
			System.out.println("------------------------");
			System.out.println(train2.toString());
			System.out.println(rb.getString("toString_message"));
			System.out.print("Все таки строка 2, изменяли несколько раз");
		}
	}
}
