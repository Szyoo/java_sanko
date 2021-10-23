package standard;

public class SeatsManager {
    // 座席予約情報Boolean数列、予約済場合はtrue
    private static boolean[] seatArray = new boolean[30];

    public static boolean checkVacanSeat(int seatNum) {
        if (seatArray[seatNum]) {
            // 指定された座席が予約済み場合
            System.out.println("\n※予約済みの座席です。他の座席を選択してください。");
            return false;
        }
        return true;
    }

    public static void reserveSeat(int seatNum) {
        seatArray[seatNum] = true;
        System.out.println("\n座席の予約が完了しました。");
    }

}
