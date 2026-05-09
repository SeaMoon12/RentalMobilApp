import java.util.Scanner;

public class RentalMobilApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalMobil rental = new RentalMobil();

        System.out.println("=== WELCOME TO CAR RENTAL ===");

        // Display available cars
        rental.tampilkanMobil();

        // Select car
        int mobilId;
        System.out.print("\nChoose a car (enter car ID): ");
        do {
            mobilId = scanner.nextInt();
            if (mobilId < 1 || mobilId > rental.getDafterMobilLength()) {
                System.out.print("Error: Invalid carID! Please select an ID between 1 and " + rental.getDafterMobilLength() + ": ");
            }
        } while (mobilId < 1 || mobilId > rental.getDafterMobilLength());

        // Input rental duration
        System.out.print("How many days would you like to rent this car? ");
        int durasi = scanner.nextInt();

        // Select payment method
        System.out.print("How would you like to pay (1 for Cash or 2 for Credit Card)? ");
        int paymentMethod = scanner.nextInt();

        // Display receipt
        rental.tampilkanStruk(mobilId, durasi, paymentMethod);

        scanner.close();
    }
}
