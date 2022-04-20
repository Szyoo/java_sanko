package practice03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int i;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("何回繰り返しますか＞");

		int roubnd = Integer.parseInt(br.readLine());
		for (i = 0; i < roubnd; i++) {
			System.out.println("今" + (i + 1) + "回目の繰り返しです");
		}
		System.out.println(i + "回繰り返しました");

	}

}
