
public class Subject extends Tawjihi {
	private String title;
	private String type;
	private int mark;

	public Subject(String title, String type, int mark) {
		setTitle(title);
		setType(type);
		setMark(mark);

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type.trim().equalsIgnoreCase("Mandatory") || type.trim().equalsIgnoreCase("ElectiveI")
				|| type.trim().equalsIgnoreCase("ElectiveII"))
			this.type = type;
		else
			System.out.println("invalid type");
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		if (mark > 0)
			this.mark = mark;
		else
			System.out.println("Enter a positive number");
	}

}
