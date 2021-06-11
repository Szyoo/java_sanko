package Lesson05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0502 {
    public static void main(String[] args) throws IOException {

        System.out.println("整数を入力してください");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);
        System.out.println(num + "が入力されました。");
    }
}
