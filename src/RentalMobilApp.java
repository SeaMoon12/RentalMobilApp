import java.util.ArrayList;
import java.util.Scanner;

public class RentalMobilApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalMobil rental = new RentalMobil();
        int paymentMethod;
        char choice;
        ArrayList<Integer> mobilIdRentals = new ArrayList<>();
        ArrayList<Integer> durasiRentals = new ArrayList<>();
        ArrayList<Integer> durasiTerlambat = new ArrayList<>();

        System.out.println("=== WELCOME TO CAR RENTAL ===");

        do {
            // Display available cars
            rental.tampilkanMobil();

            // Select car
            int mobilId;
            boolean isValid = false;
            do {
                System.out.print("\nChoose a car (enter car ID): ");
                mobilId = scanner.nextInt();

                if (mobilId < 1 || mobilId > rental.getDaftarMobilLength()) {
                    System.out.print("Error: Invalid carID! Please select an ID between 1 and " + rental.getDaftarMobilLength() + ": ");
                    continue;
                }

                if (!rental.getMobilAvailability(mobilId)) {
                    System.out.print("Error: Car with ID " + mobilId + " is not available! Please select another car: ");
                    continue;
                }

                isValid = true;
            } while (!isValid);

            mobilIdRentals.add(mobilId);

            // Change mobil availability
            rental.makeUnavailable(mobilId);

            // Input rental duration
            System.out.print("How many days would you like to rent this car? ");
            durasiRentals.add(scanner.nextInt());

            // Input duration of late return in days
            System.out.print("How many days were you late? ");
            durasiTerlambat.add(scanner.nextInt());

            // Rent more?
            System.out.print("\nWould you like to rent another car? (y/n): ");
            choice = scanner.next().charAt(0);

            if (choice == 'y' && !rental.getDaftarAvailability()) {
                System.out.println("Sorry, there are no more cars available for rent.");
                choice = 'n';
            }

        } while (choice != 'n');

        // Select payment method
        System.out.print("How would you like to pay (1 for Cash or 2 for Credit Card)? ");
        paymentMethod = scanner.nextInt();

        // Display receipt
        rental.tampilkanStruk(mobilIdRentals, durasiRentals, durasiTerlambat, paymentMethod);

        scanner.close();
    }
}
