package org.numisoft.oop2.locomotives;

/** This subclass describes 'Electrovoz' type of railroad locomotive */

public class Elektrovoz extends Locomotive {

	public static final String LOCO_TYPE = "Electrovoz";
	public static final int MAX_CAR_NUMBER = 10;

	public Elektrovoz() {
		super(LOCO_TYPE, MAX_CAR_NUMBER);
	}

}
