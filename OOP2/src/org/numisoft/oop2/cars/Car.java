package org.numisoft.oop2.cars;

/**
 * This abstract class describes general passenger railroad car
 * */

public abstract class Car implements Comparable<Car> {

	protected String cartType;
	protected int passengerNumber;
	protected int baggageNumber;
	protected int comfortLevel;
	protected int cartNumber;

	/* Constructor */
	public Car(int cartNumber, String cartType, int passangerNumber,
			int baggageNumber, int comfortLevel) {
		this.cartType = cartType;
		this.cartNumber = cartNumber;
		this.passengerNumber = passangerNumber;
		this.baggageNumber = baggageNumber;
		this.comfortLevel = comfortLevel;
	}

	/**
	 * This method compares carts by comfort level
	 * */
	@Override
	public int compareTo(org.numisoft.oop2.cars.Car o) {
		if (this.comfortLevel > o.comfortLevel) {
			return 1;
		}
		if (this.comfortLevel < o.comfortLevel) {
			return -1;
		}
		return 0;
	}

	public int getPassengerNumber() {
		return passengerNumber;
	}

	public void setPassangerNumber(int passangerNumber) {
		this.passengerNumber = passangerNumber;
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

	public int getCarNumber() {
		return cartNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}

	public String getCartType() {
		return cartType;
	}

	public void setCartType(String cartType) {
		this.cartType = cartType;
	}

}
