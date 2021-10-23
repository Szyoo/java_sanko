package enhancement;

import java.util.List;

public class SeatsManager {
    public static boolean checkVacanSeat(List<Seat> seatList, int seatNum) {
        if (seatList.get(seatNum ).getReserved()) {
            // 指定された座席が予約済み場合
            System.out.println("\n※予約済みの座席です。他の座席を選択してください。");
            return false;
        }
        return true;
    }

    public static void reserveSeat(List<Seat> seatList, int seatNum, String name) {
        seatList.get(seatNum ).setReserved(true);
        seatList.get(seatNum ).setName(name);
        System.out.println("\n座席の予約が完了しました。");
    }

}
