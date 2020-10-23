package com.medico.enums;

public enum Category {

	TABLET("Tablet"), CAPSULE("Capsule"), INJETION("Injection"), SYRUP("Syrup"), TUBE("tube"), Other("Other");

	private String name;

	Category(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
