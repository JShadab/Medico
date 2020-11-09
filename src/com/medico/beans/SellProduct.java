package com.medico.beans;

public class SellProduct {

	public SellProduct(Product product) {

		id = product.getId();

		name = product.getName();
		company = product.getCompany();

		sellingPrice = product.getSellingPrice();

		sgst = product.getSgst();
		cgst = product.getCgst();
		discount = product.getDiscount();

		units = 1;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	private int id;

	private String name;
	private String company;

	private double sellingPrice;
	private double sgst;
	private double cgst;
	private double discount;

	private int units;

	private double amount;

}
