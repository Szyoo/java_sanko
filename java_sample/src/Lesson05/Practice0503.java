package Lesson05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice0503 {
    public static void main(String[] args) throws IOException {
        System.out.println("電話番号と誕生月を入力してください。");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str1 = reader.readLine();
        String str2 = reader.readLine();

        System.out.println("電話番号は" + str1 + "です");
        System.out.println("誕生月は" + str2 + "です");
    }
}
