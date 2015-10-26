package org.numisoft.oop2.locomotives;

/**
 * This abstract class describes general railroad locomotive
 * */

public abstract class Locomotive {

	protected String locomotiveType;
	protected int maxCarNumber;

	public Locomotive(String locomotiveType, int maxCarNumber) {
		this.locomotiveType = locomotiveType;
		this.maxCarNumber = maxCarNumber;
	}

	public String getLocomotiveType() {
		return locomotiveType;
	}

	public void setLocomotiveType(String locomotiveType) {
		this.locomotiveType = locomotiveType;
	}

	public int getMaxCarNumber() {
		return maxCarNumber;
	}

	public void setMaxCarNumber(int maxCarNumber) {
		this.maxCarNumber = maxCarNumber;
	}

}
