package practice10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question01 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("電話番号を入力してください＞");
		
		String postcode = reader.readLine();
		
		if (postcode.length() != 11) {
			System.out.println("電話番号の桁数は11桁です");
		}
	}

}
