package com.github.matteomaspero.carrental.model;

public class Vehicle {
	private final String make;
	private final String model;
	private final double dailyRate;
	private boolean available;

	public Vehicle(String make, String model, double dailyRate) {
		this.make = Validate.nonEmptyString(make, "Make");
		this.model = Validate.nonEmptyString(model, "Model");
		this.dailyRate = Validate.nonNegativeRate(dailyRate);
		this.available = true;  // Default to available
	}

	// Core logic for renting and returning vehicles.

	public void rentOut() {
		if (!this.available) {
			throw new IllegalStateException("Vehicle is not available for rent.");
		}
		this.available = false;
	}

	public void turnIn() {
		this.available = true;
	}

	// Getters for the fields

	public String getMake() {
		return this.make;
	}

	public String getModel() {
		return this.model;
	}

	public double getDailyRate() {
		return this.dailyRate;
	}

	public boolean isAvailable() {
		return this.available;
	}
}
