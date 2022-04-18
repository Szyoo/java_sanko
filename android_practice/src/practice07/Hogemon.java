package practice07;

public class Hogemon {

	/** 攻撃技 */
	private String attack;
	/** 防御技 */
	private String defense;
	
	/**
	 * コンストラクタ
	 */
	public Hogemon() {
		System.out.println("野生のホゲモンがあらわれた");
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getDefense() {
		return defense;
	}

	public void setDefense(String defense) {
		this.defense = defense;
	}
	
	public void bark() {
		System.out.println("ほげほげ！");
	}

}
