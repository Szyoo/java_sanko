package practice02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int num1 = 30;
		int num2 = 23;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("1つ目の整数を入力してください＞");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("2つ目の整数を入力してください＞");
		int num2 = Integer.parseInt(reader.readLine());
		if(num1 > num2) {
			System.out.println("1つ目の数字は2つ目の数字より大きいです");
		} else  if(num1 < num2){
			System.out.println("2つ目の数字は1つ目の数字より大きいです");
		}else {
			System.out.println("2つは同じ数字です");
		}
		
	}

}
