package practice05;

public class Monster {

	public String name;
	static int count;

	public Monster(String name) {
		this.name = name;
		System.out.println("野生の" + this.name + "が現れた！");
		count++;
	}

	public static void showSum() {
		System.out.println("敵は全部で" + count + "体だ！");
	}

}
