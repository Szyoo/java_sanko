package excellence;

import java.io.BufferedReader;
import java.io.IOException;

public class Player {
    int result;
    public int getPlayerResult(BufferedReader br) throws IOException {
        // 標準入力からプレイヤーの手を決める
        // int result = -1;// プレイヤーの手を初期化
        // int result;// プレイヤーの手を初期化
        try {
            // 入力したStringをintに変換
            result = Integer.parseInt(br.readLine());
            if (result < 0 || result > 2) {
                // 0,1,2以外の数字を入力した場合は振り返る
                System.out.println("入力した値が誤っています、[0,1,2]のいずれかを入力してください");
                result = getPlayerResult(br);
            }
        } catch (NumberFormatException e) {
            // 数字以外の内容を入力した場合
            System.out.println("数字以外の内容を入力しています、正しい内容を入力してください");
            result = getPlayerResult(br);
        }
        return result;
    }

    public int getRandomResult() {
        // 乱数でコンピューターの手を決める
        int result = (int) (Math.random() * 3);
        return result;
    }

}
