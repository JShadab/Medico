package com.medico.beans;

import com.medico.enums.Category;
import com.medico.enums.ProductType;

public class Product {

	private int id;

	private String name;
	private String company;
	private Category category;
	private ProductType type;
	private String expiryDate;
	private String dealer;
	private String formula;
	private String symptoms;
	private float costPrice;
	private float sellingPrice;
	private float sgst;
	private float cgst;
	private float discount;
	private String power;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public float getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", company=" + company + ", category=" + category + ", type="
				+ type + ", expiryDate=" + expiryDate + ", dealer=" + dealer + ", formula=" + formula + ", symptoms="
				+ symptoms + ", costPrice=" + costPrice + ", sellingPrice=" + sellingPrice + ", sgst=" + sgst
				+ ", cgst=" + cgst + ", discount=" + discount + ", power=" + power + "]";
	}

}
