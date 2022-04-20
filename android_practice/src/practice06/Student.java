package practice06;

public class Student {

	private int age;
	private String name;

	public Student() {
		System.out.println("学生です");
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("名前は" + this.name + "です。年齢は" + this.age + "です。");
	}
}
