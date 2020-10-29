package main.test;

public class People {
	
	String name;
	int age;
	String gender;
	String job;
	
	public People(String name, int age, String gender, String job){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.job = job;
	}
	
	public void Speak(String words){
		
		System.out.println(this.name+"says: ["+words+"]");
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
}
