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

	private void setVehicle(Vehicle vehicle) {
		if (vehicle == null) {
			System.err.println("Vehicle cannot be null.");
			System.exit(1);
		}

		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	private void setClient(Client client) {
		if (client == null) {
			System.err.println("Client cannot be null.");
			System.exit(1);
		}

		this.client = client;
	}

	public Client getClient() {
		return this.client;
	}

	private void setStart(LocalDate start) {
		if (start == null) {
			System.err.println("Start date cannot be null.");
			System.exit(1);
		}

		this.start = start;
	}

	public LocalDate getStart() {
		return this.start;
	}

	private void setEnd(LocalDate end) {
		if (end == null) {
			System.err.println("End date cannot be null.");
			System.exit(1);
		}

		if (end.isBefore(this.start)) {
			System.err.println("End date cannot be before from date.");
			System.exit(1);
		}

		this.end = end;
	}

	public LocalDate getEnd() {
		return this.end;
	}
}
