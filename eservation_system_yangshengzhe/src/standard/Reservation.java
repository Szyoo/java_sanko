package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * コンサートホール向け座席予約システム
 * 
 * @version 1.0
 * @author Yang Shengzhe
 */

public class Reservation {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 座席予約情報Boolean数列、予約済場合はtrue
        boolean[] seatReserved = new boolean[30];

        // 予約済座席(15番)確認用
        seatReserved[14] = true;

        System.out.print("ようこそ浅草ジャマイカホールへ！\n\n");
        System.out.print("何番の座席を予約しますか？（1～30）\n＞");

        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 入力したStringをIntに転換し、数列の番号に対応する
        int seatNum = Integer.parseInt(br.readLine()) - 1;

        if (seatReserved[seatNum]) {
            // 指定された座席が予約済み場合
            System.out.println("\n※予約済みの座席です。他の座席を選択してください。");
        } else {
            // 指定された座席が予約されていない場合
            seatReserved[seatNum] = true;
            System.out.println("\n座席の予約が完了しました。");
        }
    }
}
