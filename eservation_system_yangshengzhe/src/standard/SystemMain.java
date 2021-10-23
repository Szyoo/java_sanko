package standard;

import java.io.IOException;

public class SystemMain {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int seatNum = InputController.inputSeatNum();
        if (SeatsManager.checkVacanSeat(seatNum)) {
            SeatsManager.reserveSeat(seatNum);
        }
    }
}
