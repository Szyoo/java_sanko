package practice02;

import java.util.Random;

public class Question05 {

	public static void main(String[] args) {

		System.out.println("運勢を占います");
		System.out.println("あなたの今日の運勢は");

		int omikuji = 1;
		Random rand = new Random();
		omikuji = rand.nextInt(10) + 1;

		switch (omikuji) {
			case 1:
				System.out.println("大吉です");
				break;
			case 2:
				System.out.println("中吉です");
				break;
			case 3:
				System.out.println("吉です");
				break;
			case 4:
				System.out.println("小吉です");
				break;
			case 5:
				System.out.println("凶です");
				break;
			default:
				System.out.println("大凶です");
				break;
		}
	}
}
