package lecture_3a_07;

public class Fighter {
    private int attack;
    private int hp;
    private String type;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void greeting() {
        System.out.println("戦士が現れた！");
    }

    public void setInfo(int attack, int hp, String type) {
        setAttack(attack);
        setHp(hp);
        setType(type);
        System.out.println("攻撃力：" + getAttack() + "\n体力：" + getHp() + "\nタイプ：" + getType() + "");
    }
}
