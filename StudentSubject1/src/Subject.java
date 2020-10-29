import java.util.*;



public class Subject {
	private String name;
	private ArrayList<Student> students = new ArrayList<Student>();

	public Subject(String initialName) {
		name = initialName;
	}

	public static void main(String[] args) {
		Subject fsd;
      	fsd = new Subject("Fundamentals of Software Development");
		fsd.enrolStudent("Mary");
		fsd.enrolStudent("John");
		fsd.enterMark("Mary", 75);
		fsd.enterMark("John", 65);
		System.out.println("\n\nTesting printStudentMark");
		fsd.printStudentMark("Mary");

		System.out.println("\n\nTesting printAllMarks");
		fsd.printAllMarks();
				
	}

	public void enrolStudent(String name) {
		Student s;
		s = new Student(name);
		students.add(s);
	}

	public void withdrawStudent(String name) {
		int i;
		Student s;
		for (i = 0; i < students.size(); i++)
		{
			s = students.get(i);
			if (s.getName().equals(name))
			{
				students.remove(i);
				return;
			}
		}

		System.out.println("Error: student " + name + " not found");
	}

	public void enterMark(String name, int mark) {
		int i;
		Student s;

		for (i = 0; i < students.size(); i++)
		{
			s = students.get(i);
			if (s.getName().equals(name))
			{
				s.setMark(mark);
				return;
			}
		}

		System.out.println("Error: student " + name + " not found");
	}

	public void printStudentMark(String name) {
		// Student should write code here to search
		// for the student called "name", and then
		// print his/her mark.
		//
		// Hint 1: Search using a loop like the previous method
		// Hint 2: Once you find the student, use s.printMark()
		Student s;

		for (int i = 0; i < students.size(); i++)
		{
			s = students.get(i);
			if (s.getName().equals(name))
			{
				s.printMark();
				return;
			}
		}
		System.out.println("Error: student " + name + " not found");
	}
	public void printAllMarks() {
		// Student should wrote code here to loop over
		// ALL students, and print each student's mark.
		for (Student s : students) {
			s.printMark();
		}

	}	
	
}

	