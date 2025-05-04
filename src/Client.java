import java.io.Serializable;
import java.io.Serial;

public class Client implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private String email;

	public Client(String name, String surname, String email) {
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
	}

	private void setName(String name) {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("Name cannot be null or blank.");

		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSurname(String surname) {
		if (surname == null || surname.isBlank())
			throw new IllegalArgumentException("Surname cannot be null or blank.");

		this.surname = surname;
	}

	public String getSurname() {
		return this.surname;
	}

	private void setEmail(String email) {
		if (email == null || email.isBlank())
			throw new IllegalArgumentException("Email cannot be null or blank.");

		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}
}
