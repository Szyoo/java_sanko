package lecture_1b_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question01 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 入力したStringをIntに転換
        int num = Integer.parseInt(br.readLine());
        System.out.println("整数値：" + num);
        if (num > 5) {
            System.out.println("5以上の値が入力されました。\nその値は5以上です");
        }
    }
}
