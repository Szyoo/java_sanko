package practice03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question06 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (sum < 150) {
			System.out.print("数字を入力してください＞");
			int num = Integer.parseInt(br.readLine());
			if (num % 5 == 0) {
				System.out.println("5の倍数が入力されたので引きます");
				sum -= num;
				continue;
			}
			sum += num;
		}
		System.out.println("合計" + sum + "で終了しました");

	}

}
