package validation_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author 楊聖哲
 * @author 土岐駿翔
 */
public class Question01 {
    public static void main(String[] args) {
        System.out.println("数値を入力してください");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            if (str.equals("")) {
                System.out.println("何も入力されていません");
                return;
            }
            int num = Integer.parseInt(str);
            System.out.println(num);
        } catch (Exception e) {
            System.out.println("例外が発生しました");
        } finally {
            System.out.println("システムを終了します");
        }
    }
}
