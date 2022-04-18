package practice03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		
		while (sum < 100) {
			System.out.print("数字を入力してください＞");
			int num = Integer.parseInt(reader.readLine());
			sum += num;
		}
		
		System.out.println("合計" + sum + "になったので繰り返しを終わります");
	}

}
