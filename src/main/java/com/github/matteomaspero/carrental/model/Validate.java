package com.github.matteomaspero.carrental.model;

public class Validate {
	public static Object nonNull(Object value, String name) {
		if (value == null) {
			throw new IllegalArgumentException(name + " cannot be null.");
		}
		return value;
	}

	public static String nonEmptyString(String value, String name) {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException(name + " cannot be null or empty.");
		}
		return value;
	}

	public static double nonNegativeRate(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("Rate cannot be negative.");
		}
		return value;
	}

	public static String phoneNumber(String value) {
		if (value == null || !value.matches("^\\+[0-9]{12}$")) {
			throw new IllegalArgumentException("Phone number must be a valid format. [+ccxxxxxxxxxx]");
		}
		return value;
	}
}
