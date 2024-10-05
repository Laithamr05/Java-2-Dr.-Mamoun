
public class Tawjihi extends Student {
	private int seatingNum;
	private int year = 2024;
	private String[] subject = new String[10];

	public Tawjihi(int ID, String name, char gender, String school, int seatingNum) {
		super(ID, name, gender, school);
		this.seatingNum = seatingNum;

	}

	public int getSeatingNum() {
		return seatingNum;
	}

	public void setSeatingNum(int seatingNum) {
		if (seatingNum > 0)
			this.seatingNum = seatingNum;
		else
			System.out.println("invalid seating num");
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String[] getSubject() {
		return subject;
	}

	public void setSubject(String[] subject) {
		this.subject = subject;
	}

}
