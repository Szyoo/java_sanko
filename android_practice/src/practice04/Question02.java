package practice04;

import java.io.IOException;

public class Question02 {

	public static void main(String[] args) throws IOException {
		String[] favoriteFoods = new String[3];

		favoriteFoods[0] = "チョコレート";
		favoriteFoods[1] = "チーズ";
		favoriteFoods[2] = "ハンバーグ";

		System.out.println("好きな食べ物を3つ表示します。");

		for (String favoriteFood : favoriteFoods) {
			System.out.println(favoriteFood);
		}
	}

}
