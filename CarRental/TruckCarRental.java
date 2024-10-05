
public class TruckCarRental extends CarRental {
	private boolean isPickUp;

	public TruckCarRental(String size, int days, String name, boolean isPickUp) {
		super.setName(name);
		super.setSize(size);
		super.setDays(days);
		this.isPickUp =isPickUp;
	}

	public boolean isPickUp() {
		return isPickUp;
	}

	public void setPickUp(boolean isPickUp) {
		this.isPickUp = isPickUp;
	}

	public double computeTotal(int days) {
		if(isPickUp == false)
		return super.computeTotal(days);
		return super.computeTotal(days) + 20*days;
	}

	public String toString() {
		return super.toString();
	}


}
