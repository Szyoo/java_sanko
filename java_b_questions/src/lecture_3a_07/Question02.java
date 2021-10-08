package lecture_3a_07;

public class Question02 {
    public static void main(String[] args) {
        int taxedPrice;
        Calc calc = new Calc();
        taxedPrice = calc.taxCalc(1300);
        System.out.println("税込み価格は" + taxedPrice + "円です");
    }
}
