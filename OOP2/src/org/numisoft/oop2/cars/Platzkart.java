package org.numisoft.oop2.cars;

/**
 * This subclass describes 'Platzkart' type of passenger car, for more
 * information on 'Platzkart' please refer to wikipedia @
 * https://en.wikipedia.org/wiki/Couchette_car
 * */

public class Platzkart extends Car {

	public static final String CAR_TYPE = "Platzkart";
	public static final int PASS_NUM = 52;
	public static final int BAG_NUM = 104;
	public static final int COMF_LVL = 3;

	public Platzkart(int carNumber) {
		super(carNumber, CAR_TYPE, PASS_NUM, BAG_NUM, COMF_LVL);
	}

}
