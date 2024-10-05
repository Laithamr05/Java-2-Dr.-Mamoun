public class Student {
	private int ID;
	private String name;
	private char gender;
	private String school;

	public Student(int ID, String name, char gender, String school) {
		setID(ID);
		setName(name);
		setGender(gender);
		setSchool(school);
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		if (ID >= 0)
			ID = this.ID;
		else
			System.out.println("Invalid ID");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if (gender == 'm' || gender == 'f')
			this.gender = gender;
		else
			System.out.println("Seek some help");
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}
