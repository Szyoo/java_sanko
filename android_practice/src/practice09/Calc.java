package practice09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {

	public void division() throws NumberFormatException, IOException, ArithmeticException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("1つ目の数字を入力してください＞");
			
			int num1 = Integer.parseInt(br.readLine());
			
			System.out.print("2つ目の数字を入力してください＞");
			
			int num2 = Integer.parseInt(br.readLine());
			
			int result = num1 / num2;
			
			System.out.println("割り算すると" + result + "です");
		}
}
