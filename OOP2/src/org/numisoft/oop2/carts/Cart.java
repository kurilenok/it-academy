package org.numisoft.oop2.carts;

public abstract class Cart implements Comparable<Cart> {

	protected int passangerNumber;
	protected int baggageNumber;
	protected int comfortLevel;

	@Override
	public int compareTo(org.numisoft.oop2.carts.Cart o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPassangerNumber() {
		return passangerNumber;
	}

	public void setPassangerNumber(int passangerNumber) {
		this.passangerNumber = passangerNumber;
	}

	public int getBaggageNumber() {
		return baggageNumber;
	}

	public void setBaggageNumber(int baggageNumber) {
		this.baggageNumber = baggageNumber;
	}

	public int getComfortLevel() {
		return comfortLevel;
	}

	public void setComfortLevel(int comfortLevel) {
		this.comfortLevel = comfortLevel;
	}

	public Cart(int passangerNumber, int baggageNumber, int comfortLevel) {
		this.passangerNumber = passangerNumber;
		this.baggageNumber = baggageNumber;
		this.comfortLevel = comfortLevel;
	}

}
