package practice06;

public class Student {
	
	private int age;
	private String name;
	
	public Student() {
		System.out.println("学生です");
	}
	
	public Student(int age, String name) {
		this.age = age;
		this.name = name;
		
		System.out.println("名前は" + this.name + "です。年齢は" + this.age + "です。");
	}
}
