package org.numisoft.oop2.locomotives;

import org.numisoft.oop2.Main;

/** This subclass describes 'Elektrovoz' type of railroad locomotive */

public class Elektrovoz extends Locomotive {

	public static String LOCO_TYPE = Main.rb.getString("elektrovoz");
	public static final int MAX_CAR_NUMBER = 12;

	public Elektrovoz() {
		super(LOCO_TYPE, MAX_CAR_NUMBER);
	}

}
