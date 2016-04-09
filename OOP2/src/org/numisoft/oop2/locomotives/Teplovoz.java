package org.numisoft.oop2.locomotives;

import org.numisoft.oop2.Main;

/** This subclass describes 'Teplovoz' type of railroad locomotive */

public class Teplovoz extends Locomotive {

	public static String LOCO_TYPE = Main.rb.getString("teplovoz");
	public static final int MAX_CART_NUMBER = 20;

	public Teplovoz() {
		super(LOCO_TYPE, MAX_CART_NUMBER);

	}

}
