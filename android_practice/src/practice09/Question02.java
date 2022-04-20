package practice09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question02 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("数字を入力してください＞");
		
		try {
			int num = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("入力値に間違いがあります");
		} finally {
			System.out.println("処理を終了しました");
		}
	}

}
