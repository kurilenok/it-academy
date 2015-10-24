package org.numisoft.oop2;

import java.util.ArrayList;
import java.util.List;

import org.numisoft.oop2.carts.Cart;
import org.numisoft.oop2.locomotives.Locomotive;

public class Train {

	private Locomotive locomotive;
	private List<Cart> carts = new ArrayList<Cart>();
	private int maxCartNumber;
	private int cartNumber;
	private int totalPassangerNumber;
	private int totalBaggageNumber;

	public void addLocomotive(Locomotive locomotive) {
		this.locomotive = locomotive;
		setMaxCartNumber(locomotive.getMaxCartNumber());
	}

	public void addCart(Cart cart) {
		carts.add(cart);
	}

	public int getMaxCartNumber() {
		return maxCartNumber;
	}

	public void setMaxCartNumber(int maxCartNumber) {
		this.maxCartNumber = maxCartNumber;
	}

	public int getTotalPassangerNumber() {
		for (Cart c : carts) {
			totalPassangerNumber += c.getPassangerNumber();
		}
		return totalPassangerNumber;
	}

	public int getTotalBaggageNumber() {
		for (Cart c : carts) {
			totalBaggageNumber += c.getBaggageNumber();
		}
		return totalBaggageNumber;
	}

}
