package practice10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import javafx.beans.binding.StringBinding;

public class Question04 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("入学年月日を入力してください＞");
		String entryDay = reader.readLine();
		
		System.out.println("生年月日を入力してください＞");
		String birthday = reader.readLine();
		
		StringBuilder sb = new StringBuilder(entryDay);
		sb.append(birthday);
		
		System.out.println("あなたの学籍番号は"+ sb +"です。");
		
		
	}

}
