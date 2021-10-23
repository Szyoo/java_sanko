package stream_file_io_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question01 {
    public static void main(String[] args) throws IOException {
        // No.1
        String path = "C:/Users/losin/Desktop/new_file.txt";
        String text = "New Test Test";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            // No.4
            System.out.println("新しいファイルが存在します");
        }
        write(file, text, false);

        // No.2
        read(file);

        // No.3
        write(file, "New Test Test Version 2", false);

        // 追加課題

        // No.1
        write(file, "New Test\r\nTest\r\n", false);

        // No.3
        write(file, "Version 2", true);
    }

    private static void write(File file, String line, Boolean append) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, append));
            bw.write(line);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(File file) {
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
