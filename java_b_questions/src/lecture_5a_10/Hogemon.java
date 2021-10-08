package lecture_5a_10;

public class Hogemon {
    /** レベル */
    private int level;
    /** 体力 */
    private int hp;
    /** 攻撃力 */
    private int attack;

    /*** コンストラクタ */
    public Hogemon() {
        System.out.println("ホゲモンが誕生しました");
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void bark() {
        System.out.println("ほげほげ！");
    }
}
