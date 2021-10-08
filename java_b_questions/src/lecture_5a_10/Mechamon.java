package lecture_5a_10;

public class Mechamon extends Hogemon {

    public Mechamon() {
    }
    
    public Mechamon(int level, int hp, int attack) {
        super();
        setLevel(level);
        setHp(hp);
        setAttack(attack);
    }

    @Override
    public void bark() {
        System.out.println("メチャメチャ！");
    }

    public void showData() {
        System.out.println("メモチャモン：\nレベル" + getLevel() + "\n体力" + getHp() + "\n攻撃力" + getAttack());
    }

    public void attack() {
        System.out.println("メモチャモンの攻撃！");
    }
}
