package practice06;

public class Child {

	private String name;
	private int age;
	
	public Child(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Child(String name) {
		this(name, 0);
	}
	
	public Child() {
		this("情報なし", 0);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
