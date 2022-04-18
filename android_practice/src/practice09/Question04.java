package practice09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question04 {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("1つ目の数字を入力してください＞");
			
			int num1 = Integer.parseInt(reader.readLine());
			
			System.out.print("2つ目の数字を入力してください＞");
			
			int num2 = Integer.parseInt(reader.readLine());
			
			int result =  num1 / num2;
			
			System.out.println("割り算すると" + result + "です");
		} catch (NumberFormatException | IOException | ArithmeticException e) {
			e.printStackTrace();
		}
	}

}
