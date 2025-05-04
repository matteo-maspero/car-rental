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
		if (nextId < Vehicle.nextId) {
			System.err.println("Next ID must be greater than the current ID.");
			System.exit(1);
		}

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
		if (pricePerDay < 0) {
			System.err.println("Vehicle price per day must be a non-negative number.");
			System.exit(1);
		}

		this.pricePerDay = pricePerDay;
	}

	public float getPricePerDay() {
		return this.pricePerDay;
	}

	private void setMake(String make) {
		if (make == null || make.isBlank()) {
			System.err.println("Vehicle make cannot be null or blank.");
			System.exit(1);
		}

		this.make = make;
	}

	public String getMake() {
		return this.make;
	}

	private void setModel(String model) {
		if (model == null || model.isBlank()) {
			System.err.println("Vehicle model cannot be null or blank.");
			System.exit(1);
		}

		this.model = model;
	}

	public String getModel() {
		return this.model;
	}

	private void setLicensePlate(String licensePlate) {
		if (licensePlate == null || !licensePlate.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) {
			System.err.println("Vehicle license plate format is invalid.");
			System.exit(1);
		}

		this.licensePlate = licensePlate;
	}

	public String getLicensePlate() {
		return this.licensePlate;
	}

	private void setSeats(int seats) {
		if (seats <= 0) {
			System.err.println("Vehicle seats must be a positive number.");
			System.exit(1);
		}

		this.seats = seats;
	}

	public int getSeats() {
		return this.seats;
	}
}
