package lecture_1a_09;

public class Supporter {
    private static int sum = 0;

    public Supporter() {
        addSum();
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        Supporter.sum = sum;
    }

    public void addSum() {
        setSum(getSum() + 1);
        System.out.println("サポーターが現れた！");
    }

    public void showSum() {
        System.out.println("サポーターは" + getSum() + "体います");
    }
}
