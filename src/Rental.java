import java.io.Serializable;
import java.io.Serial;
import java.time.LocalDate;

public class Rental implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Vehicle vehicle;
	private Client client;
	private LocalDate start;
	private LocalDate end;

	public Rental(Vehicle vehicle, Client client, LocalDate start, LocalDate end) {
		this.setVehicle(vehicle);
		this.setClient(client);
		this.setStart(start);
		this.setEnd(end);
	}

	public Rental(Vehicle vehicle, Client client, LocalDate start, int days) {
		this(vehicle, client, start, start.plusDays(days));
	}

	private void setVehicle(Vehicle vehicle) {
		if (vehicle == null)
			throw new IllegalArgumentException("Vehicle cannot be null.");

		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	private void setClient(Client client) {
		if (client == null)
			throw new IllegalArgumentException("Client cannot be null.");

		this.client = client;
	}

	public Client getClient() {
		return this.client;
	}

	private void setStart(LocalDate start) {
		if (start == null)
			throw new IllegalArgumentException("From date cannot be null.");

		this.start = start;
	}

	public LocalDate getStart() {
		return this.start;
	}

	private void setEnd(LocalDate end) {
		if (end == null)
			throw new IllegalArgumentException("To date cannot be null.");

		this.end = end;
	}

	public LocalDate getEnd() {
		return this.end;
	}
}
