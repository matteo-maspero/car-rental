package matteomaspero.carrental.model;

import java.util.Date;

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
			throw new IllegalArgumentException("Rate must be greater than zero.");
		}
		return value;
	}

	public static String phoneNumber(String value) {
		if (value == null || !value.matches("^\\+[0-9]{12}$")) {
			throw new IllegalArgumentException("Phone number must be a valid format.");
		}
		return value;
	}

	public static Date endDateAfterStartDate(Date startDate, Date endDate) {
		if (startDate == null) {
			throw new IllegalArgumentException("Start date cannot be null.");
		}
		if (endDate == null) {
			throw new IllegalArgumentException("End date cannot be null.");
		}
		if (endDate.before(startDate)) {
			throw new IllegalArgumentException("End date must be after start date.");
		}
		return endDate;
	}
}
