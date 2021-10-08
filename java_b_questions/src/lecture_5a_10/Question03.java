package lecture_5a_10;

public class Question03 {
    public static void main(String[] args) {
        Hogemon mechamon = new Mechamon();
        mechamon.bark();
        mechamon.setLevel(10);
        mechamon.setHp(100);
        mechamon.setAttack(20);
        System.out.println(
                "メモチャモン：\nレベル" + mechamon.getLevel() + "\n体力" + mechamon.getHp() + "\n攻撃力" + mechamon.getAttack());
    }
}
