package lecture_3b_03;

import java.io.FileWriter;
import java.io.IOException;

public class Question01 {
    public static void main(String[] args) throws IOException {
        String path = "C:/Users/losin/Desktop/file.txt";
        String text = "テストテスト";
        FileWriter fr = new FileWriter(path, false);
        fr.write(text);
        fr.flush();
        fr.close();
    }
}
