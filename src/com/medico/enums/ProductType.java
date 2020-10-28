package com.medico.enums;

public enum ProductType {

	MEDICINE("Medicine"), EQUIPMENT("Equipment"), OTHER("Other");

	private String name;

	ProductType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public static ProductType getEnum(String name) {

		switch (name) {
		case "Medicine":
			return MEDICINE;
		case "Equipment":
			return EQUIPMENT;

		default:
			return OTHER;
		}
	}

}
