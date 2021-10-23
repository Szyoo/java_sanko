package lecture_1a_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question01 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("数字を入力してください＞");
        int num = Integer.parseInt(reader.readLine());
    }
}