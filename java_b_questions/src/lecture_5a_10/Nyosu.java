package lecture_5a_10;

public class Nyosu extends Hogemon {
    
    public Nyosu() {
    }

    public Nyosu(int level, int hp, int attack) {
        super();
        setLevel(level);
        setHp(hp);
        setAttack(attack);
    }

    @Override
    public void bark() {
        System.out.println("にょにょ！");
    }

    public void showData() {
        System.out.println("ニョース：\nレベル" + getLevel() + "\n体力" + getHp() + "\n攻撃力" + getAttack());
    }
}
