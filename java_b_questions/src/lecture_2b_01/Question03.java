package lecture_2b_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question03 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("何回繰り返しますか");
        // 入力したStringをIntに転換
        int num = Integer.parseInt(br.readLine());
        if (num < 0) {
            System.out.println("*");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
        }
    }
}
