package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class janken {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] jankenType = { "グー", "チョキ", "パー" }; // 0-2の数字とじゃんけんの手を対応する
        int winCountPlayer = 0; // プレイヤーの勝ち合計
        int winCountRivals = 0; // コンピューターの勝ち合計
        System.out.println("【ジャンケン開始】\n");
        // 標準入力BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            System.out.println("【" + (i + 1) + "回戦目】\nプレイヤーの手を決めてください\n（グー：0 チョキ:1 パー:2）");
            int choosen = Integer.parseInt(br.readLine()); // 入力したStringをintに変換、プレイヤーの手
            int rivalsChoosen = getRandomJanken(); // コンピューターの手
            int result = choosen - rivalsChoosen; // プレイヤーにとして、じゃんけんの結果、合計三種類: -2と1負け,-1と2は勝つ,0は引き分け
            System.out.println(jankenType[choosen] + " vs. " + jankenType[rivalsChoosen]);
            if (result == 0) {
                // 引き分け
                System.out.println("引き分けです！\n");
            } else if (result == -1 || result == 2) {
                // プレイヤーが勝ち
                winCountPlayer++;
                System.out.println("プレイヤーが勝ちました！\n");
            } else {
                // コンピューターが勝ち
                winCountRivals++;
                System.out.println("コンピューターが勝ちました！\n");
            }
        }
        System.out.print("【ジャンケン終了】\n\n" + winCountPlayer + "対" + winCountRivals + "で");
        if (winCountPlayer > winCountRivals) {
            System.out.println("プレイヤーの勝ちです！\n");
        } else if (winCountPlayer < winCountRivals) {
            System.out.println("コンピューターの勝ちです！\n");
        } else {
            System.out.println("引き分けです！\n");
        }
    }

    private static int getRandomJanken() {
        // 乱数でコンピューターの手を決める
        int result = (int) (Math.random() * 3);
        return result;
    }
}
