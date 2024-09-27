package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Train {
    // A 2D array to represent the seats on the train (4 seats per row, 23 rows)
    private static Seat[][] seats = new Seat[23][4];

    // Constructor initializes the seats on the train
    public Train() {
        int seatNumber = 1;
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 4; j++) {
                seats[i][j] = new Seat(seatNumber++);
            }
        }
    }

    // Method to reserve a seat
    public boolean reserveSeat(int seatNumber, String passengerName) {
        if (!Seat.isValid(seatNumber)) {
            return false; // Invalid seat number
        }

        int row = Seat.getRow(seatNumber) - 1;
        int column = Seat.getColoumn(seatNumber) - 1;

        if (seats[row][column].isEmpty()) {
            seats[row][column].setPassengerName(passengerName);
            return true; // Seat reserved successfully
        }
        return false; // Seat already reserved
    }

    // Method to delete a reserved seat
    public boolean deleteSeat(int seatNumber) {
        if (!Seat.isValid(seatNumber)) {
            return false; // Invalid seat number
        }

        int row = Seat.getRow(seatNumber) - 1;
        int column = Seat.getColoumn(seatNumber) - 1;

        if (!seats[row][column].isEmpty()) {
            seats[row][column].setPassengerName(null);
            return true; // Seat reservation deleted successfully
        }
        return false; // Seat is already empty
    }

    // Method to delete all reserved seats
    public void deleteAllSeats() {
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 4; j++) {
                seats[i][j].setPassengerName(null); // Empty each seat
            }
        }
    }

    // Method to read passenger file and populate the seat reservations
    public void readPassengerFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            int seatNumber = Integer.parseInt(parts[0].trim());
            String passengerName = parts[1].trim();

            if (Seat.isValid(seatNumber) && seats[Seat.getRow(seatNumber) - 1][Seat.getColoumn(seatNumber) - 1].isEmpty()) {
                reserveSeat(seatNumber, passengerName);
            }
        }
        reader.close();
    }

    // Method to write all reserved seats back to the file
    public void updatePassengerFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 4; j++) {
                if (!seats[i][j].isEmpty()) {
                    writer.write(seats[i][j].getSeatNumber() + ": " + seats[i][j].getPassengerName() + "\n");
                }
            }
        }
        writer.close();
    }

    // Display all seats with their status
    public void displaySeats() {
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(seats[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
