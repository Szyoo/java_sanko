package lecture_2b_01;

public class Question06 {
    public static void main(String[] args) {
        int[] scores = new int[5];
        int sum = 0;
        int average = 0;
        System.out.print("scores[] = {");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = (int) (Math.random() * 100);
            sum += scores[i];
            if (i < scores.length - 1) {
                System.out.print(scores[i] + ", ");
            } else {
                System.out.print(scores[i] + "}");
            }
        }
        average = sum / scores.length;
        System.out.println("\n合計点は" + sum + "点です。");
        System.out.println("平均点は" + average + "点です。");
    }
}
