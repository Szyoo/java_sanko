package practice10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question02 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("小文字で英単語を入力してください＞");
		
		String lowerCase = reader.readLine();
		
		String upperCase = lowerCase.toUpperCase();
		
		System.out.println(upperCase);
	}

}
