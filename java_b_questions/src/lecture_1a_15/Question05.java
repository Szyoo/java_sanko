package lecture_1a_15;

import java.io.IOException;

public class Question05 {
    public static void main(String[] args) {
        Calc calc = new Calc();
        try {
            calc.warizan();
        } catch (NumberFormatException | ArithmeticException | IOException e) {
            System.out.println("例外が起きました");
        }
    }
}
