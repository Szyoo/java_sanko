package lecture_1b_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question02 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("整数を入力してください");
        // 入力したStringをIntに転換
        int num = Integer.parseInt(br.readLine());
        if (num < 20) {
            System.out.println("その値は20未満です。");
        }
    }
}
