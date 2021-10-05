package lecture_1b_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question03 {
    public static void main(String[] args) throws IOException {
        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("何を食べますか");
        // 入力したStringをIntに転換
        String foods = br.readLine();
        switch (foods) {
            case "和食":
                System.out.println("おにぎりをどうぞ");
                break;
            case "洋食":
                System.out.println("パンをどうぞ");
                break;
            default:
                System.out.println("残念ながら用意できません");
                break;
        }
    }
}
