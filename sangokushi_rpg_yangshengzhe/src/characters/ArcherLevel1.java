package characters;

import constants.Constant;

public class ArcherLevel1 extends Character {

    public ArcherLevel1(String name, int level, int exp, int hitpoint, int leadership, int martial, int intellect) {
        super(name, level, exp, hitpoint, leadership, martial, intellect);
        // TODO Auto-generated constructor stub
        super.setBranch(Constant.ARCHERLEVEL1_NAME);
    }

    private double attackAdj = 1.0; // 攻撃補正
    private double guardAdj = 1.0; // 防御補正
    private double speedAdj = 1.0; // スピード補正

    public int attack() { // 攻撃
        Double aV = getMartial() * attackAdj;
        int attackValue = aV.intValue();
        return attackValue;
    }

    public int guard() { // 防御
        Double dV = getLeadership() * guardAdj;
        int defenseValue = dV.intValue();
        return defenseValue;
    }
}
