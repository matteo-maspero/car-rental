package clients;

public abstract class Client {
	private String name;
	private String email;
	private String phoneNumber;

	public Client(String name, String email, String phoneNumber) {
		this.setName(name);
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
	}

	private void setName(String name) {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("Name cannot be null or blank.");

		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	private void setEmail(String email) {
		if (email == null || email.isBlank())
			throw new IllegalArgumentException("Email cannot be null or blank.");

		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	private void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.isBlank())
			throw new IllegalArgumentException("Phone number cannot be null or blank.");

		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
}
