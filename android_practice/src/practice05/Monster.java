package practice05;

public class Monster {
	
	public String name;
	static int sum;
	
	public Monster(String name) {
		this.name = name;
		System.out.println("野生の" + this.name + "が現れた！");
		sum++;
	}
	
	public static void showSum() {
		System.out.println("敵は全部で" + sum + "体だ！");
	}

}
