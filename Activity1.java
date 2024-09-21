package practice;

public class Activity1 {
	private int seatNumber;
	private String passengerName;

	public Activity1(int seatNumber) {
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

	public boolean isEmpty(int seatNumber) {
		return this.passengerName == null;
	}

	public String toString() {
		return "Seat Number = " + seatNumber + "Passenger Name = " + passengerName + "isOccupied = "
				+ isEmpty(seatNumber);
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
