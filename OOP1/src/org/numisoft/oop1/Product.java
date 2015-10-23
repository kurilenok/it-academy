package org.numisoft.oop1;

/* Class "Product" describes typical product item */

public class Product {

	/* String "id" stores unique product identifier */
	public int id;

	/* String "name" stores product name */
	public String name;

	/* String "UPC" stores 8-digit Universal Product Code (UPC or bar code) */
	public String UPC;

	/* String "manufacturer" stores brand name of manufacturer */
	public String manufacturer;

	/* "price" stores current price, USD per item */
	public double price;

	/* "expiration" stores expirate date */
	public String expiration;

	/* "quantity" stores number of items available */
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the uPC
	 */
	public String getUPC() {
		return UPC;
	}

	/**
	 * @param uPC
	 *            the uPC to set
	 */
	public void setUPC(String uPC) {
		UPC = uPC;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the expiration
	 */
	public String getExpiration() {
		return expiration;
	}

	/**
	 * @param expiration
	 *            the expiration to set
	 */
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
