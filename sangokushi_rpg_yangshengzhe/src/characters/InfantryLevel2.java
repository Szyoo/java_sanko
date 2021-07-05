package characters;

import constants.Constant;

public class InfantryLevel2 extends InfantryLevel1 {

    public InfantryLevel2(String name, int level, int exp, int hitpoint, int leadership, int martial, int intellect) {
        super(name, level, exp, hitpoint, leadership, martial, intellect);
        // TODO Auto-generated constructor stub
        super.setBranch(Constant.INFANTRYLEVEL2_NAME);
    }

    private double attackAdj = 1.0; // 攻撃補正
    private double guardAdj = 1.4; // 防御補正
    private double speedAdj = 0.8; // スピード補正

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
