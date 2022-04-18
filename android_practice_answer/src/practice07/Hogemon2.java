package practice07;

public class Hogemon2 {

	private int level;
	private int hp;
	private int attack;
	
	public Hogemon2(int level, int hp, int attack) {
		this.level = level;
		this.hp = hp;
		this.attack = attack;
	}
	
	public void showInfo() {
		System.out.println("レベル：" + level + "\n体力：" + hp + "\n攻撃力" + attack);
	}
}
