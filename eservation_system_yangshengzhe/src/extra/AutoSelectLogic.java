package extra;

import java.util.ArrayList;
import java.util.List;

public class AutoSelectLogic {
    public static void autoSelect(List<Seat> seatList, int seatNum, User user) {
        List<Integer> reservable = new ArrayList<Integer>();
        List<Integer> unreservable = new ArrayList<Integer>();
        for (int i = 0; i < seatList.size(); i++) {
            if (!seatList.get(i).getReserved()) { // 空いている座席
                if (!unreservable.contains(i)) {
                    reservable.add(i);
                }
            } else {// 予約済み座席
                if (!unreservable.contains(i)) {
                    unreservable.add(i);
                }
                switch (i) {
                    case 0:
                        if (reservable.contains(1)) {
                            reservable.remove(1);
                            unreservable.add(1);
                        }
                        break;
                    case 29:
                        if (reservable.contains(29)) {
                            reservable.remove(29);
                            unreservable.add(28);
                        }
                        break;
                    default:
                        if (reservable.contains(i + 1)) {
                            reservable.remove(i + 1);
                            unreservable.add(i + 1);
                        }
                        if (reservable.contains(i - 1)) {
                            reservable.remove(i - 1);
                            unreservable.add(i - 1);
                        }
                        break;
                }
            }
        }
        System.out.println(reservable.toString());
        System.out.println(unreservable.toString());
    }
}
