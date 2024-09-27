package practice;

public class Seat {
	private int seatNumber;
	private String passengerName;

	public Seat(int seatNumber) {
		this.seatNumber = seatNumber;
		this.passengerName = null;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public boolean isEmpty() {
		return this.passengerName == null;
	}

	public String toString() {
		return "Seat Number = " + seatNumber + "Passenger Name = " + passengerName + "isOccupied = "
				+ isEmpty();
	}
    public static boolean isValid(int seatNumber) {
    	return seatNumber>0 && seatNumber<93;
    }
    public static int getRow(int seatNumber) {
    	if(!isValid(seatNumber)) 
    		return -1;
    	return (seatNumber-1)/5;
    }
    public static int getColoumn(int seatNumber) {
    	if(!isValid(seatNumber)) 
    		return -1;
    	return (seatNumber - 1)%5;
    	}
    }
