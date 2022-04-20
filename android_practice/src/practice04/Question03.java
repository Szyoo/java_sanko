package practice04;

import java.util.Random;

public class Question03 {

	public static void main(String[] args) {
		String[] seasoning = { "塩", "醤油", "ソース", "ケチャップ", "胡椒" };

		String[] dish = { "ステーキ", "ハンバーグ", "オムライス", "たらこパスタ", "ハンバーガー" };

		Random rand = new Random();
		int i = rand.nextInt(5);
		int j = rand.nextInt(5);

		System.out.println("私は" + dish[i] + "に" + seasoning[j] + "をかけるのが好きです");
	}

}
