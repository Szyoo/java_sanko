package Lesson05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice0502 {
    public static void main(String[] args) throws IOException {
        System.out.println("西暦を入力してください");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str) + 1;

        System.out.println("来年は" + num + "年です");
    }
}
