package lecture_2b_01;

public class Question04 {
    public static void main(String[] args) {
        int[] scores = { 23, 44, 14, 52, 21 };
        for (int i = 0; i < scores.length; i = i + 2) {
            System.out.println(i + 1 + "つ目の点数は" + scores[i] + "点です");
        }
    }
}
