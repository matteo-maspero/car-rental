import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

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

	public void addVehicle(float pricePerDay, String make, String model, String licencePlate, int seats) {
		for (Vehicle vehicle : this.vehicles) {
			if (vehicle.getLicensePlate().equals(licencePlate)) {
				System.out.println("Vehicle with this licence plate already exists.");
				return;
			}
		}

		this.vehicles.add(new Vehicle(pricePerDay, make, model, licencePlate, seats));
	}

	public void addClient(String name, String surname, String email) {
		this.clients.add(new Client(name, surname, email));
	}

	public void addRental(int vehicleId, int clientId, LocalDate start, LocalDate end) {
		for (Rental rental : this.rentals) {
			if (rental.getVehicle().getId() != vehicleId) {
				continue;
			}

			if (
				start.isAfter(rental.getStart()) && start.isBefore(rental.getEnd()) ||
					end.isAfter(rental.getStart()) && end.isBefore(rental.getEnd()) ||
					start.isEqual(rental.getStart()) || end.isEqual(rental.getEnd())
			) {
				System.out.println("Vehicle is already rented during this period.");
				return;
			}
		}

		Vehicle vehicle = this.vehicles.get(vehicleId);
		Client client = this.clients.get(clientId);
		this.rentals.add(new Rental(vehicle, client, start, end));
	}

	public void addRental(int vehicleId, int clientId, LocalDate start, int days) {
		this.addRental(vehicleId, clientId, start, start.plusDays(days));
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

	@SuppressWarnings("unchecked")
	public void loadVehicles(String path) {
		try (
			FileInputStream fileInputStream = new FileInputStream(path);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
		) {
			Object readObject = objectInputStream.readObject();

			if (!(readObject instanceof ArrayList<?> readList)) {
				throw new ClassCastException("File does not contain an ArrayList.");
			}

			if (readList.isEmpty()) {
				throw new ClassCastException("Read list is empty.");
			}

			for (Object element : readList) {
				if (!(element instanceof Vehicle)) {
					throw new ClassCastException("Read list contains non-Vehicle objects.");
				}
			}

			this.vehicles.clear();
			this.vehicles.addAll((ArrayList<Vehicle>) readList);
			Vehicle.updateNextId(this.vehicles.size());
		} catch (IOException e) {
			System.out.println("No vehicles file found, a new one will be created on exit.");
		} catch (ClassNotFoundException | ClassCastException e) {
			System.err.println("Error loading vehicles: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void loadClients(String path) {
		try (
			FileInputStream fileInputStream = new FileInputStream(path);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
		) {
			Object readObject = objectInputStream.readObject();

			if (!(readObject instanceof ArrayList<?> readList)) {
				throw new ClassCastException("File does not contain an ArrayList.");
			}

			if (readList.isEmpty()) {
				throw new ClassCastException("Read list is empty.");
			}

			for (Object element : readList) {
				if (!(element instanceof Client)) {
					throw new ClassCastException("Read list contains non-Client objects.");
				}
			}

			this.clients.clear();
			this.clients.addAll((ArrayList<Client>) readList);
		} catch (IOException e) {
			System.out.println("No clients file found, a new one will be created on exit.");
		} catch (ClassNotFoundException | ClassCastException e) {
			System.err.println("Error loading clients: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void loadRentals(String path) {
		try (
			FileInputStream fileInputStream = new FileInputStream(path);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
		) {
			Object readObject = objectInputStream.readObject();

			if (!(readObject instanceof ArrayList<?> readList)) {
				throw new ClassCastException("File does not contain an ArrayList.");
			}

			if (readList.isEmpty()) {
				throw new ClassCastException("Read list is empty.");
			}

			for (Object element : readList) {
				if (!(element instanceof Rental)) {
					throw new ClassCastException("Read list contains non-Rental objects.");
				}
			}

			this.rentals.clear();
			this.rentals.addAll((ArrayList<Rental>) readList);
		} catch (IOException e) {
			System.out.println("No rentals file found, a new one will be created on exit.");
		} catch (ClassNotFoundException | ClassCastException e) {
			System.err.println("Error loading rentals: " + e.getMessage());
		}
	}

	public void saveVehicles(String path) {
		try (
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
		) {
			objectOutputStream.writeObject(this.vehicles);
		} catch (IOException e) {
			System.err.println("Error saving vehicles: " + e.getMessage());
		}
	}

	public void saveClients(String path) {
		try (
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
		) {
			objectOutputStream.writeObject(this.clients);
		} catch (IOException e) {
			System.err.println("Error saving clients: " + e.getMessage());
		}
	}

	public void saveRentals(String path) {
		try (
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
		) {
			objectOutputStream.writeObject(this.rentals);
		} catch (IOException e) {
			System.err.println("Error saving rentals: " + e.getMessage());
		}
	}
}
