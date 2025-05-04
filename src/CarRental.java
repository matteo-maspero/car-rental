import java.io.Serializable;
import java.io.Serial;
import java.util.ArrayList;

public class CarRental implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private final ArrayList<Vehicle> vehicles;
	private final ArrayList<Client> clients;
	private final ArrayList<Rental> rentals;

	public CarRental() {
		this.vehicles = new ArrayList<>();
		this.clients = new ArrayList<>();
		this.rentals = new ArrayList<>();
	}

	public void addVehicle(Vehicle vehicle) {
		if (vehicle == null)
			throw new IllegalArgumentException("Vehicle cannot be null.");

		this.vehicles.add(vehicle);
	}

	public void addClient(Client client) {
		if (client == null)
			throw new IllegalArgumentException("Client cannot be null.");

		this.clients.add(client);
	}

	public void addRental(Rental rental) {
		if (rental == null)
			throw new IllegalArgumentException("Rental cannot be null.");

		this.rentals.add(rental);
	}

	public Vehicle getVehicle(int index) {
		return this.vehicles.get(index);
	}

	public Client getClient(int index) {
		return this.clients.get(index);
	}

	public Rental getRental(int index) {
		return this.rentals.get(index);
	}
}
