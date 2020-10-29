public class Student {
	private String name;
	private int mark;

	public Student(String initialName) {
		name = initialName;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setMark(int newMark) {
		this.mark = newMark;
	}

	public String getName() {
		return this.name;
	}

	public int getMark() {
		return this.mark;
	}

	public void printMark() {
		System.out.println("Student " + name +
			" has a mark of " + mark);
	}
}

