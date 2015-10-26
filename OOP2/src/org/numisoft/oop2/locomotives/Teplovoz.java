package org.numisoft.oop2.locomotives;

/** This subclass describes 'Teplovoz' type of railroad locomotive */

public class Teplovoz extends Locomotive {

	public static final String LOCO_TYPE = "Teplovoz";
	public static final int MAX_CART_NUMBER = 15;

	public Teplovoz() {
		super(LOCO_TYPE, MAX_CART_NUMBER);
	}

}
