package org.numisoft.oop2.cars;

/**
 * This subclass describes 'Kupe' type of passenger car, for more information on
 * 'Kupe' please refer to wikipedia @
 * https://en.wikipedia.org/wiki/Corridor_coach
 * */

public class Kupe extends Car {

	public static final String CAR_TYPE = "Kupe";
	public static final int PASS_NUM = 36;
	public static final int BAG_NUM = 72;
	public static final int COMF_LVL = 2;

	public Kupe(int carNumber) {
		super(carNumber, CAR_TYPE, PASS_NUM, BAG_NUM, COMF_LVL);
	}

}
