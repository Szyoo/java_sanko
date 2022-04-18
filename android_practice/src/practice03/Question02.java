package practice03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("何回繰り返しますか＞");
		
		int repeat = Integer.parseInt(reader.readLine());
		
		int i;
		
		for(i = 0; i < repeat; i++) {
			System.out.println("今" + (i + 1) + "回目の繰り返しです");
		}
		
		System.out.println(i + "回繰り返しました");

	}

}
