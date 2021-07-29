package enhancement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * コンサートホール向け座席予約システム
 * 
 * @version 1.1
 * @author Yang Shengzhe
 */

public class Reservation {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 座席予約情報Boolean数列、予約済場合はtrue
        boolean[] seatReserved = new boolean[30];

        // 残席15席以下の場合確認用
        for (int i = 0; i < 16; i++) {
            seatReserved[i] = true;
        }

        // 残席0席の場合確認用
        // for (int i = 0; i < seatReserved.length; i++) {
        // seatReserved[i]=true;
        // }

        Lable: while (true) {

            System.out.print("ようこそ浅草ジャマイカホールへ！\n\n");

            // 座席の予約状況を確認する
            int seatReservedCount = 0;
            for (int i = 0; i < seatReserved.length; i++) {
                if (seatReserved[i]) {
                    seatReservedCount++;
                }
            }

            // 各種予約状況の表示処理
            if (seatReservedCount == 30) {
                // 完売する場合にはプログラムを終了する
                System.out.println("完売しています。\n");
                break;
            } else if (seatReservedCount > 15) {
                System.out.println("残りあと数席です。\n");
            } else {
                System.out.println("まだ余裕があります。\n");
            }

            System.out.print("何番の座席を予約しますか？（1～30）\n＞");

            // 標準入力
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int seatNum = 0;
            while (true) {
                // 入力したStringをIntに転換し
                String str = br.readLine();
                int num = Integer.parseInt(str);
                if (num > 0 && num <= 30) {
                    // 正しい入力した場合、数列の番号に対応する
                    seatNum = num - 1;
                    break;
                } else {
                    System.out.println("正しい数字（1～30）を入力してください！\n");
                }
            }

            if (seatReserved[seatNum]) {
                // 指定された座席が予約済み場合、プログラムを再起動する
                System.out.println("\n※予約済みの座席です。他の座席を選択してください。\n--------------------------\n\n");
            } else {
                // 指定された座席が予約されていない場合、指定された座席を予約する
                seatReserved[seatNum] = true;
                System.out.println("\n座席の予約が完了しました。");
                // プログラムを再起動の確認
                while (true) {
                    System.out.println("続けて予約しませんか？\nY/N");
                    String choice = br.readLine();
                    if (choice.equals("Y")||choice.equals("y")) {
                        break;
                    } else if (choice.equals("N")||choice.equals("n")) {
                        // プログラムを終了する
                        break Lable;
                    } else {
                        System.out.println("正しい内容を入力してください！\n");
                    }
                }
            }
        }
    }
}
