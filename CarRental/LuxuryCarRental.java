
public class LuxuryCarRental extends CarRental {

	private boolean addDriver;

	public LuxuryCarRental(String size, int days, String name, boolean addDriver) {
		super(size, days, name);
		this.addDriver = addDriver;
	}

	public boolean isAddDriver() {
		return addDriver;
	}

	public void setAddDriver(boolean addDriver) {
		this.addDriver = addDriver;
	}

	public double computeTotal(int days) {
		if (addDriver == false)
			return super.computeTotal(days);
		return super.computeTotal(days) + 50*days;
	}

	public String toString() {
		return super.toString();
	}

}
