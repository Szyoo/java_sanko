package characters;

import constants.Constant;

public class Character {
    private String name; // 名前
    private int level; // レベル
    private int exp; // 経験値
    private int hitpoint; // 体力
    private int leadership; // 統率
    private int martial; // 武力
    private int intellect; // 知力
    private String branch; // 兵科

    public int attack() { // 攻撃
        int attackValue = getMartial();
        return attackValue;
    }

    public int guard() { // 防御
        int defenseValue = getLeadership();
        return defenseValue;
    }

    public void showCharacter() { // 選択したキャラクターの数値を表示する
        String name = getName();
        System.out.println("\nあなたは [" + name + "] としてプレイします。");
        int leadership = getLeadership();
        int martial = getMartial();
        int intellect = getIntellect();
        String branchName = getBranch();

        System.out.println("\nキャラクター数値:\n" + Constant.NAME + ": " + name);
        System.out.println(Constant.LEADERSHIP + ": " + leadership);
        System.out.println(Constant.MARTIAL + ": " + martial);
        System.out.println(Constant.INTELLECT + ": " + intellect);
        System.out.println(Constant.BRANCH + ": " + branchName);
        System.out.println("\n" + name + "の覇道が始まります！");
    }

    public Character(String name, int level, int exp, int hitpoint, int leadership, int martial, int intellect) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.hitpoint = hitpoint;
        this.leadership = leadership;
        this.martial = martial;
        this.intellect = intellect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getHitpoint() {
        return hitpoint;
    }

    public void setHitpoint(int hitpoint) {
        this.hitpoint = hitpoint;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public int getMartial() {
        return martial;
    }

    public void setMartial(int martial) {
        this.martial = martial;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}
