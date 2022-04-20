package practice03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question04 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("最初の数を入力してください＞");
		int num1 = Integer.parseInt(br.readLine());

		do {
			System.out.print("足す数字を入力してください＞");
			int num2 = Integer.parseInt(br.readLine());
			num1 += num2;
		} while (num1 <= 100);

		System.out.println("100より大きくなったので" + num1 + "で終了しました");
	}

}
