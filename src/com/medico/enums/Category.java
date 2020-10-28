package com.medico.enums;

public enum Category {

	TABLET("Tablet"), CAPSULE("Capsule"), INJETION("Injection"), SYRUP("Syrup"), TUBE("tube"), OTHER("Other");

	private String name;

	Category(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public static Category getEnum(String name) {

		switch (name) {
		case "Tablet":
			return TABLET;
		case "Capsule":
			return CAPSULE;
		case "Injection":
			return INJETION;
		case "Syrup":
			return SYRUP;
		case "tube":
			return TUBE;
		default:
			return OTHER;
		}
	}

}
