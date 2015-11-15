package org.numisoft.oop2.cars;

import org.numisoft.oop2.Main;

/**
 * This subclass describes 'SV' aka 'Spalnyj' type of passenger car, for more
 * information on 'SV' please refer to wikipedia @
 * https://en.wikipedia.org/wiki/Sleeping_car
 * */

public class Sv extends Car {

	public static String CAR_TYPE = Main.rb.getString("sv");
	public static final int PASS_NUM = 18;
	public static final int BAG_NUM = 54;
	public static final int COMF_LVL = 1;

	public Sv(int carNumber) {
		super(carNumber, CAR_TYPE, PASS_NUM, BAG_NUM, COMF_LVL);
	}

}
