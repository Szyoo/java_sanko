package validation_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question01 {
    public static void main(String[] args) throws IOException {
        System.out.println("郵便番号を入力してください");
        System.out.println("入力例:XXX-XXXX");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Pattern p = Pattern.compile("^[0-9]{3}-[0-9]{4}$");
        Matcher m = p.matcher(str);
        System.err.println(m.find());
    }
}
