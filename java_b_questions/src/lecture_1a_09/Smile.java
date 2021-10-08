package lecture_1a_09;

public class Smile {
    /** 体力 */
    private int hp;
    /** 攻撃 */
    private int attack;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp > 0) {
            this.hp = hp;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack > 0) {
            this.attack = attack;
        }
    }

}
