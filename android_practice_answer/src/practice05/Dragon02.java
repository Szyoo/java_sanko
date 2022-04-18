package practice05;

public class Dragon02 {
	
	public void attack() {
		System.out.println("ドラゴンは技を外した！");
	}
	
	public void attack(String attackName) {
		System.out.println("ドラゴンの" + attackName + "攻撃！");
	}
	
	public void attack(String attackName, int repeat) {
		for (int i = 0; i < repeat; i++) {
			System.out.println("ドラゴンの" + attackName + "攻撃！");
		}
	}

}
