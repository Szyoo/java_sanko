package practice02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question04 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int omikuji = 3;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("好きな整数を入力してください＞");
		omikuji = Integer.parseInt(br.readLine());
		if (omikuji == 1) {
			System.out.println("今日はいい日になります");
		} else if (omikuji == 2) {
			System.out.println("今日はそこそこの日になります");
		} else {
			System.out.println("予想できない1日になります");
		}
	}
}
