package practice10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question06 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("メールアドレスを入力してください＞");

		String email = br.readLine();

		Pattern p = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+(.[a-zA-Z]+)*$");

		Matcher m = p.matcher(email);

		if(m.find()){
		    System.out.println("OKです");
		}else{
		    System.out.println("やり直してください");
		}

	}

}
