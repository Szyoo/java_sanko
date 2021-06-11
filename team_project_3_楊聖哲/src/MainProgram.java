import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * チームメンバー：
 *			楊聖哲
 */

public class MainProgram {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isRestart = false;
        boolean inputUncorrect = false;
        lableA: do {
            bmi person = new bmi();
            person.runBMIAdvance();
            do {
                System.out.println(
                        "-----------------------\nBMI計算を再度行いますか？\nBMI計算を再度行い場合は「Y」を、BMI計算を再度行わない場合は「N」を入力してください。");
                String option1 = reader.readLine();
                if (option1.equals("Y")) {
                    isRestart = true;
                    break;
                } else if (option1.equals("N")) {
                    isRestart = true;
                    System.out.println("BMI計算プログラムを終了します。");
                    break lableA;
                } else {
                    System.out.println("不適切な入力がされました。もう一度正しく入力してください。");
                    inputUncorrect = true;
                }
            } while (inputUncorrect);
        } while (isRestart);
    }
}