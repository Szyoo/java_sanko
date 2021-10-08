package lecture_1a_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {
    public Calc() {
    }

    public void warizan() throws NumberFormatException, IOException, ArithmeticException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("1つ目の数字を入力してください＞");
        int num1 = Integer.parseInt(reader.readLine());
        System.out.print("1つ目の数字を入力してください＞");
        int num2 = Integer.parseInt(reader.readLine());
        System.out.println(num1 / num2);
    }
}
