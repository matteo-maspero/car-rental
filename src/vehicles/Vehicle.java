package vehicles;

public abstract class Vehicle {
	private static int counter = 0;

	private int id;
	private String make;
	private String model;
	private String licensePlate;
	private int seats;
	private float pricePerDay;

	public Vehicle(String make, String model, String licensePlate, int seats, float pricePerDay) {
		this.generateId();
		this.setMake(make);
		this.setModel(model);
		this.setLicensePlate(licensePlate);
		this.setSeats(seats);
		this.setPricePerDay(pricePerDay);
	}

	private void generateId() {
		this.id = ++counter;
	}

	public int getId() {
		return this.id;
	}

	private void setMake(String make) {
		if (make == null || make.isBlank())
			throw new IllegalArgumentException("Vehicle make cannot be null or blank.");

		this.make = make;
	}

	public String getMake() {
		return this.make;
	}

	private void setModel(String model) {
		if (model == null || model.isBlank())
			throw new IllegalArgumentException("Vehicle model cannot be null or blank.");

		this.model = model;
	}

	public String getModel() {
		return this.model;
	}

	private void setLicensePlate(String licensePlate) {
		if (licensePlate == null || licensePlate.isBlank())
			throw new IllegalArgumentException("Vehicle license plate cannot be null or blank.");

		this.licensePlate = licensePlate;
	}

	public String getLicensePlate() {
		return this.licensePlate;
	}

	private void setSeats(int seats) {
		if (seats <= 0)
			throw new IllegalArgumentException("Vehicle seats must be a positive number.");

		this.seats = seats;
	}

	public int getSeats() {
		return this.seats;
	}

	public void setPricePerDay(float pricePerDay) {
		if (pricePerDay < 0)
			throw new IllegalArgumentException("Vehicle price per day must be a non-negative number.");

		this.pricePerDay = pricePerDay;
	}

	public float getPricePerDay() {
		return this.pricePerDay;
	}
}
