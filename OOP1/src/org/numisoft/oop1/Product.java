package org.numisoft.oop1;

public class Product {

	public int id;
	public String name;
	public String UPC;
	public String manufacturer;
	public double price;
	public String expiration;
	public int quantity;

	public Product(int id, String name, String UPC, String manufacturer,
			double d, String expiration, int quantity) {
		this.id = id;
		this.name = name;
		this.UPC = UPC;
		this.manufacturer = manufacturer;
		this.price = d;
		this.expiration = expiration;
		this.quantity = quantity;

	}
}
