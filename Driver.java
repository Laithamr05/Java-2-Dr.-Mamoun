package practice;

import java.io.IOException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Train train = new Train();
        Scanner scanner = new Scanner(System.in);
        String filename = "passengers.txt"; // Example filename

        while (true) {
            // Display menu
            System.out.println("Menu:");
            System.out.println("1. Read passengers file");
            System.out.println("2. Reserve a new empty seat");
            System.out.println("3. Delete a reserved seat");
            System.out.println("4. Delete all reserved seats");
            System.out.println("5. Update passengers file");
            System.out.println("6. Quit");

            // Ask the user to choose an option
            System.out.print("Choose an option: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Read passengers file
                    try {
                        train.readPassengerFile(filename);
                        train.displaySeats();
                    } catch (IOException e) {
                        System.out.println("Error reading the file: " + e.getMessage());
                    }
                    break;
                case 2:
                    // Reserve a new empty seat
                    System.out.print("Enter seat number: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid seat number. Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                        continue;
                    }
                    int seatNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();

                    if (train.reserveSeat(seatNumber, passengerName)) {
                        System.out.println("Seat reserved successfully.");
                    } else {
                        System.out.println("Seat reservation failed. Seat may already be reserved or invalid.");
                    }
                    break;
                case 3:
                    // Delete a reserved seat
                    System.out.print("Enter seat number to delete: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid seat number. Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                        continue;
                    }
                    seatNumber = scanner.nextInt();

                    if (train.deleteSeat(seatNumber)) {
                        System.out.println("Seat reservation deleted successfully.");
                    } else {
                        System.out.println("Failed to delete seat reservation. Seat may already be empty or invalid.");
                    }
                    break;
                case 4:
                    // Delete all reserved seats
                    train.deleteAllSeats();
                    System.out.println("All reserved seats deleted.");
                    break;
                case 5:
                    // Update passengers file
                    try {
                        train.updatePassengerFile(filename);
                        System.out.println("Passenger file updated.");
                    } catch (IOException e) {
                        System.out.println("Error writing to the file: " + e.getMessage());
                    }
                    break;
                case 6:
                    // Exit program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
