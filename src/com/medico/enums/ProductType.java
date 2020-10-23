package com.medico.enums;

public enum ProductType {

	MEDICINE("Medicine"), EQUIPMENT("Equopment"), OTHER("Other");

	private String name;

	ProductType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
