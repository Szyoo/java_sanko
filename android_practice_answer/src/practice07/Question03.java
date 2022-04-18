package practice07;

public class Question03 {

	public static void main(String[] args) {
		Hogemon mochamon = new Mochamon();
		
		mochamon.bark();
		
		mochamon.setAttack("たいあたり");
		mochamon.setDefense("かくれる");
		
		System.out.println("モチャモンの" + mochamon.getAttack() + "\n大ダメージだ！");
		System.out.println("モチャモンの" + mochamon.getDefense() + "\n攻撃が当たらない");
		
	}

}
