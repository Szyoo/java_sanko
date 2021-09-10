package excellence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemMain {
    static int choosen;

    public static void main(String[] args) {
        String[] jankenType = { "グー", "チョキ", "パー" }; // 0-2の数字とじゃんけんの手を対応する
        int winCountPlayer = 0; // プレイヤーの勝ち合計
        int winCountRivals = 0; // コンピューターの勝ち合計
        System.out.println("【ジャンケン開始】\n");

        // 標準入力BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Player player = new Player(); // Playerクラスを呼び出し

        for (int i = 0; i < 3; i++) {
            System.out.println("【" + (i + 1) + "回戦目】\nプレイヤーの手を決めてください\n（グー：0 チョキ:1 パー:2）");

            try {
                choosen = player.getPlayerResult(br);
            } catch (IOException e) {
                // ファイルシステムエラーなどのIOExceptionを発生した場合
                System.out.println("システムエラーが発生しました。");
                System.out.println("システムを終了します。");
                break;
            } // プレイヤーの手
            int rivalsChoosen = player.getRandomResult(); // コンピューターの手

            System.out.println(jankenType[choosen] + " vs. " + jankenType[rivalsChoosen]);

            int result = JankenJudge.judge(choosen, rivalsChoosen); // プレイヤーにとして、結果を取る
            switch (result) {
                case -1:
                    // コンピューターが勝ち
                    winCountRivals++;
                    break;

                case 1:
                    // プレイヤーが勝ち
                    winCountPlayer++;
                    break;
            }
        }

        System.out.print("【ジャンケン終了】\n\n" + winCountPlayer + "対" + winCountRivals + "で");
        if (winCountPlayer > winCountRivals) {
            System.out.println("プレイヤーの勝ちです！\n");
        } else if (winCountPlayer < winCountRivals) {
            System.out.println("コンピューターの勝ちです！\n");
        } else if (winCountPlayer == winCountRivals) {
            System.out.println("引き分けです！\n");
        }

    }
}
