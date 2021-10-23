package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {
    public static int inputSeatNum() throws NumberFormatException, IOException {
        System.out.print("ようこそ浅草ジャマイカホールへ！\n\n");
        System.out.print("何番の座席を予約しますか？（1～30）\n＞");

        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 入力したStringをIntに転換し、数列の番号に対応する
        int seatNum = Integer.parseInt(br.readLine()) - 1;
        return seatNum;
    }

}
