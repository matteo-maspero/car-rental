import java.io.Serial;
import java.io.Serializable;

public class Vehicle implements Serializable {
	private static int nextId = 0;

	@Serial
	private static final long serialVersionUID = 1L;

	private int id;
	private float pricePerDay;
	private String make;
	private String model;
	private String licensePlate;
	private int seats;

	public static void updateNextId(int nextId) {
		if (nextId < Vehicle.nextId)
			throw new IllegalArgumentException("Next ID must be greater than the current ID.");

		Vehicle.nextId = nextId;
	}

	public static int getNextId() {
		return Vehicle.nextId;
	}

	public Vehicle(float pricePerDay, String make, String model, String licensePlate, int seats) {
		this.generateId();
		this.setPricePerDay(pricePerDay);
		this.setMake(make);
		this.setModel(model);
		this.setLicensePlate(licensePlate);
		this.setSeats(seats);
	}

	private void generateId() {
		this.id = nextId++;
	}

	public int getId() {
		return this.id;
	}

	public void setPricePerDay(float pricePerDay) {
		if (pricePerDay < 0)
			throw new IllegalArgumentException("Vehicle price per day must be a non-negative number.");

		this.pricePerDay = pricePerDay;
	}

	public float getPricePerDay() {
		return this.pricePerDay;
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
}
