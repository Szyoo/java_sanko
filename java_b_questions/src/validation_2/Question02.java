package validation_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question02 {
    public static void main(String[] args) throws IOException {
        System.out.println("半角英字を入力してください");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println(str + "は半角英字です");
        } else {
            System.out.println(str + "半角英字ではありません");
        }
    }
}
