package org.numisoft.oop2.cars;

import org.numisoft.oop2.Main;

/**
 * This subclass describes 'Obschij' aka 'Sidjachij' type of passenger car
 * */

public class Obschij extends Car {

	public static String CAR_TYPE = Main.rb.getString("obschij");
	public static final int PASS_NUM = 64;
	public static final int BAG_NUM = 64;
	public static final int COMF_LVL = 4;

	public Obschij(int carNumber) {
		super(carNumber, CAR_TYPE, PASS_NUM, BAG_NUM, COMF_LVL);
	}

}
