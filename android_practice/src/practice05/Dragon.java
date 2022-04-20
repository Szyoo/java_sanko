package practice05;

public class Dragon {

	public void attack() {
		System.out.println("ドラゴンは技を外した！");
	}

	public void attack(String skillName) {
		System.out.println("ドラゴンの" + skillName + "攻撃！");
	}

	public void attack(String skillName, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println("ドラゴンの" + skillName + "攻撃！");
		}
	}
}
