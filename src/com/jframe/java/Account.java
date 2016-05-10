package com.jframe.java;

public class Account {

	private String id;
	private String name;
	private double price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}
	public Account(String id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
