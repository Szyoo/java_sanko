package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {
    public static int inputSeatNum() throws NumberFormatException, IOException {
        while (true) {
            System.out.print("何番の座席を予約しますか？（1～30）\n＞");

            // 標準入力
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // 入力したStringをIntに転換し、数列の番号に対応する
            int seatNum = Integer.parseInt(br.readLine()) - 1;
            if (seatNum < 30 && seatNum >= 0) {
                return seatNum;
            } else {
                System.out.print("请输入1-30之间的半角数字！");
            }
        }
    }

    public static String inputName() throws IOException {
        System.out.print("お名前を入力してください\n＞");

        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 入力したStringをIntに転換し、数列の番号に対応する
        String name = br.readLine();
        return name;
    }

    public static User inputUser() throws IOException {
        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 入力したStringをIntに転換し、数列の番号に対応する

        System.out.print("お名前を入力してください\n＞");
        String name = br.readLine();
        System.out.print("電話番号を入力してください\n＞");
        String tel = br.readLine();
        System.out.print("e-Mailを入力してください\n＞");
        String mail = br.readLine();
        System.out.print("性別を入力してください\n＞");
        String gender = br.readLine();
        System.out.print("年齢を入力してください\n＞");
        int age = Integer.parseInt(br.readLine());
        User user = new User(name, tel, mail, gender, age);
        return user;
    }

}
