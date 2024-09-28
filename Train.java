
public class Train {

	private static Seat seats[][] = new Seat[23][];

	public Train() {
		int seatNumber = 1;
		for (int i = 0; i < 23; i++) {
			for (int j = 0; i < 4; i++) {
				seatNumber++;
			}

		}
	}

	public boolean reserveSeat(int seatNumber, String passengerName) {
		if (!Seat.isValid(seatNumber))
			return false;
		int row = Seat.getRow(seatNumber);
		int coloumn = Seat.getColoumn(seatNumber);

		if (Seat.isEmpty(passengerName)) {
			seats[row][coloumn].setPassengerName(passengerName);
			return true;
		}
		return false;

	}

	public boolean deleteSeat(int seatNumber, String passengerName) {
		int row = Seat.getRow(seatNumber);
		int coloumn = Seat.getColoumn(seatNumber);

		if (!Seat.isValid(seatNumber))
			return false;
		if (Seat.isEmpty(passengerName))
			return false;

		seats[row][coloumn].setPassengerName(null);
		return true;
	}

	public boolean deleteAll(int seatNumber, String passengerName) {
		for (int i = 0; i < 23; i++) {
			for (int j = 0; i < 4; i++) {
				seatNumber++;
				int row = Seat.getRow(seatNumber);
				int coloumn = Seat.getColoumn(seatNumber);
				seats[row][coloumn].setPassengerName(null);
			}

		}
		return true;
	}

	public void print(int seatNumber) {
		for (int i = 0; i < 23; i++) {
			for (int j = 0; i < 4; i++) {
				seatNumber++;
				int row = Seat.getRow(seatNumber);
				int coloumn = Seat.getColoumn(seatNumber);

			}
		}
	}
}