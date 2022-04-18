package practice02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question06 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("年齢を入力してください＞");
		
		int age = Integer.parseInt(reader.readLine());
		
		if (16 <= age && age < 18) {
			System.out.println("保護者同伴で入れます");
		} else if (18 <= age && age < 20) {
			System.out.println("入れますが飲酒と喫煙は禁止です");
		} else if (20 <= age) {
			System.out.println("入れます");
		} else if (age < 16) {
			System.out.println("入ることができません");
		}
		
	}

}
