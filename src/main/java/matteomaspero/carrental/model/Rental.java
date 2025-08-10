package matteomaspero.carrental.model;

import java.util.Date;

public class Rental {
	private final Vehicle vehicle;
	private final String customerFullName;
	private final String customerPhoneNumber;
	private final Date startDate;
	private final Date endDate;

	public Rental(Vehicle vehicle, String customerFullName, String customerPhoneNumber, Date startDate, Date endDate) {
		this.vehicle = (Vehicle) Validate.nonNull(vehicle, "Vehicle");
		this.customerFullName = Validate.nonEmptyString(customerFullName, "Customer full name");
		this.customerPhoneNumber = Validate.phoneNumber(customerPhoneNumber);
		this.startDate = (Date) Validate.nonNull(startDate, "Start date");
		this.endDate = (Date) Validate.nonNull(endDate, "End date");

		if (endDate.before(startDate)) {
			throw new IllegalStateException("End date cannot be before start date.");
		}
	}

	// Getters for the fields

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public String getCustomerFullName() {
		return this.customerFullName;
	}

	public String getCustomerPhoneNumber() {
		return this.customerPhoneNumber;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public Date getEndDate() {
		return this.endDate; // Return a copy to prevent external modification
	}
}
