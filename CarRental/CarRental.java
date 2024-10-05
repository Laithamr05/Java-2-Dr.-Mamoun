
public class CarRental {
	private String name = "Kia";
	private String size = "s";
	private double dailyFee = 29.99;
	private int days;

	public CarRental() {

	}

	public CarRental(String size, int days, String name) {
		setSize(size);
		setDays(days);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		if (size.trim().equalsIgnoreCase("s") || size.trim().equalsIgnoreCase("m")
				|| size.trim().equalsIgnoreCase("o")) {
			this.size = size;
			switch (size) {
			case "s":
				setDailyFee(29.99);
				break;
			case "m":
				setDailyFee(38.99);
				break;
			case "o":
				setDailyFee(43.50);
				break;

			}
		} else
			System.out.println("Size not supported");
	}

	public double getDailyFee() {
		return dailyFee;
	}

	public void setDailyFee(double dailyFee) {
		if (dailyFee > 0)
			this.dailyFee = dailyFee;
		else
			System.out.println("Daily Fee must be positive");

	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		if (days > 0)
			this.days = days;
		else
			System.out.println("Days must be positive");

	}

	public double computeTotal(int days) {
		return days * dailyFee;
	}

	public String toString() {
		return name + " " + size + " " + dailyFee;
	}
}
