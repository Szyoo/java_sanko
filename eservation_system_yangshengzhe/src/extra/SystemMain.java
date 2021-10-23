package extra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SystemMain {
    public static void main(String[] args) {
        System.out.print("ようこそ浅草ジャマイカホールへ！\n\n");
        List<Seat> seatList = new ArrayList<Seat>();
        for (int i = 0; i < 30; i++) {
            seatList.add(new Seat("", false));
        }
        try {
            while (true) {
                int seatNum = InputController.inputSeatNum();
                if (SeatsManager.checkVacanSeat(seatList, seatNum)) {
                    User user = InputController.inputUser();
                    SeatsManager.reserveSeat(seatList, seatNum, user);
                    break;
                }
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("システムエラーが発生しました。\nシステムを終了します。");
        }
    }
}
