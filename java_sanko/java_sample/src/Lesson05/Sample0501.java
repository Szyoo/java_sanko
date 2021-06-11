package Lesson05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0501 {
    public static void main(String[] args) throws IOException {
        System.out.println("文字列を入力してください");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        System.out.println(str + "が入力されました。");
    }
}
