package practice05;

public class Slime {

	private int hp;
	private int attack;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if (hp > 0) {
			this.hp = hp;
		}
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		if (attack > 0) {
			this.attack = attack;
		}
	}
}
