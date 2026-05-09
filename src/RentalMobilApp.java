import java.util.Scanner;

public class RentalMobilApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalMobil rental = new RentalMobil();

        System.out.println("=== WELCOME TO CAR RENTAL ===");

        // Display available cars
        rental.tampilkanMobil();

        // Select car
        System.out.print("\nChoose a car (enter car ID): ");
        int mobilId = scanner.nextInt();

        // Input rental duration
        System.out.print("How many days would you like to rent this car? ");
        int durasi = scanner.nextInt();

        // Display receipt
        rental.tampilkanStruk(mobilId, durasi);

        scanner.close();
    }
}
