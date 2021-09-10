package excellence;

public class JankenJudge {

    public static int judge(int choosen, int rivalsChoosen) {
        int result = choosen - rivalsChoosen;
        // プレイヤーにとして、じゃんけんの結果、合計三種類: -2と1負け,-1と2は勝つ,0は引き分け
        // プレイヤーにとして、負けた場合は-1、勝つは1、引き分けは0を戻る
        if (result == 0) {
            // 引き分け
            System.out.println("引き分けです！\n");
            return 0;
        } else if (result == -1 || result == 2) {
            // プレイヤーが勝ち
            System.out.println("プレイヤーが勝ちました！\n");
            return 1;
        } else {
            // コンピューターが勝ち
            System.out.println("コンピューターが勝ちました！\n");
            return -1;
        }
    }
}
