package practice03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question04 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("最初の数を入力してください＞");
		
		int startNum = Integer.parseInt(reader.readLine());
		
		do {
			System.out.print("足す数字を入力してください＞");
			int minusNum = Integer.parseInt(reader.readLine());
			startNum += minusNum;
		} while (startNum <= 100);
		
		System.out.println("100より大きくなったので" + startNum + "で終了しました");
	}

}
