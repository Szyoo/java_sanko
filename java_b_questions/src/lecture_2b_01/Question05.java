package lecture_2b_01;

public class Question05 {
    public static void main(String[] args) {
        int[][] scores = new int[2][4];

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = (int) (Math.random() * 100);
                System.out.println(" scores[" + i + "][" + j + "] = " + scores[i][j]);
            }
        }
    }
}
