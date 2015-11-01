package org.numisoft.oop2;

/**
 * This class is entry point to application
 * */
public class Main {

	public static void main(String[] args) {

		Train train = new Train();

		/* Adding locomotive to the train */
		train.addLocomotive();

		/* Adding cars to the train */
		train.addCars();

		/* Writing train to file */
		train.writeTrain();

		/* Calculating total passenger number */
		System.out.println("------------------------");
		System.out.println("Total passenger number is: " + train.getTotalPassangerNumber());

		/* Calculating total baggage number */
		System.out.println("------------------------");
		System.out.println("Total baggage number is: " + train.getTotalBaggageNumber());

		/* Selecting cars by passenger number */
		train.getCarsByPassangerNumber();

		/* Sorting cars by comfort level */
		train.sortCarsByComfortLevel();

		/* Reading train from file */
		Train train2 = Train.readTrain();

		if (train2.getTotalPassangerNumber() == 0) {
			System.out.println("-------------");
		} else {
			System.out.println("Locomotive is " + train2.getLocomotive().getLocomotiveType());
			train2.showCars();
		}
	}

}
