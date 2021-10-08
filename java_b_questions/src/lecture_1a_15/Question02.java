package lecture_1a_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question02 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("数字を入力してください＞");
            int num = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("入力値に間違いがあります");
        } finally {
            System.out.println("処理を終了しました");
        }
    }
}