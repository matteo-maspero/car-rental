import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		CarRental carRental = new CarRental();

		carRental.loadVehicles("vehicles.csv");
		carRental.loadClients("clients.csv");
		carRental.loadRentals("rentals.csv");

		carRental.addVehicle(69,"aaa", "bbb", "AE123BA", 4);
		carRental.addClient("yyy", "www", "sss");
		carRental.addRental(2, 1, LocalDate.now(), 2);

		carRental.saveVehicles("vehicles.csv");
		carRental.saveClients("clients.csv");
		carRental.saveRentals("rentals.csv");
	}
}