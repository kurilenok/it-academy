package org.numisoft.oop2.locomotives;

public abstract class Locomotive {

	protected int maxCartNumber;

	public int getMaxCartNumber() {
		return maxCartNumber;
	}

	public void setMaxCartNumber(int maxCartNumber) {
		this.maxCartNumber = maxCartNumber;
	}

	public Locomotive(int maxCartNumber) {
		this.maxCartNumber = maxCartNumber;
	}

}
