package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import characters.ArcherLevel1;
import characters.ArcherLevel2;
import characters.CavalryLevel1;
import characters.CavalryLevel2;
import characters.InfantryLevel1;
import characters.InfantryLevel2;
import constants.Constant;

public class MainProgram {
    public static void unCorrectInput() { // 設定と違う値を入力した場合にコメントを提示するためのメゾット
        System.out.println("!!!正しい内容を入力してください!!!");
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        String l = "--------------\n"; // 美観的な分割線

        System.out.println(l + "三国志　孫権伝");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println(l + "新しいキャラクターを登録しますか？\n[Y]を入力して新しいキャラクターを登録する\n[N]を入力して孫権としてプレイする");
            // 標準入力したStringをUpperCaseに変更する
            String choosenResult = reader.readLine().toUpperCase(); // Userがキャラーを選択できる機能

            if (choosenResult.equals("Y")) { // 新しいキャラクターをつくる場合
                // 対象の数値を使いための変数の初期化
                String name;
                Integer level;
                Integer hitpoint;
                Integer leadership;
                Integer martial;
                Integer intellect;
                Integer branchType;
                // 名前を入力する
                System.out.println(l + "新しいキャラクターの数値設定が始まります。\n名前を入力してください。");
                name = reader.readLine();
                // レベルを正しい範囲内入力する
                while (true) {
                    System.out.println(l + "レベル(数字1-" + Constant.MAX_LEVEL + ")を入力してください。");
                    level = Integer.parseInt(reader.readLine());
                    if (level > 0 && level <= Constant.MAX_LEVEL) {
                        break;
                    } else {
                        unCorrectInput();
                    }
                }
                // 体力を正しい範囲内入力する
                while (true) {
                    System.out.println(l + "体力(数字1-" + Constant.MAX_HITPOINT + ")を入力してください。");
                    hitpoint = Integer.parseInt(reader.readLine());
                    if (hitpoint > 0 && hitpoint <= Constant.MAX_HITPOINT) {
                        break;
                    } else {
                        unCorrectInput();
                    }
                }
                // 統率を正しい範囲内入力する
                while (true) {
                    System.out.println(l + "統率(数字1-" + Constant.MAX_LEADERSHIP + ")を入力してください。");
                    leadership = Integer.parseInt(reader.readLine());
                    if (leadership > 0 && leadership <= Constant.MAX_LEADERSHIP) {
                        break;
                    } else {
                        unCorrectInput();
                    }
                }
                // 武力を正しい範囲内入力する
                while (true) {
                    System.out.println(l + "武力(数字1-" + Constant.MAX_MARTIAL + ")を入力してください。");
                    martial = Integer.parseInt(reader.readLine());
                    if (martial > 0 && martial <= Constant.MAX_MARTIAL) {
                        break;
                    } else {
                        unCorrectInput();
                    }
                }
                // 知力を正しい範囲内入力する
                while (true) {
                    System.out.println(l + "知力(数字1-" + Constant.MAX_INTELLECT + ")を入力してください。");
                    intellect = Integer.parseInt(reader.readLine());
                    if (intellect > 0 && intellect <= Constant.MAX_INTELLECT) {
                        break;
                    } else {
                        unCorrectInput();
                    }
                }
                // 兵科番号を正しい範囲内入力する
                while (true) {
                    System.out.println(l + "数字(1-6)を入力して、兵科を選択してください。");
                    System.out.println("[1] を入力して、[軽歩兵] を選択する");
                    System.out.println("[2] を入力して、[重歩兵] を選択する");
                    System.out.println("[3] を入力して、[弓兵] を選択する");
                    System.out.println("[4] を入力して、[弩兵] を選択する");
                    System.out.println("[5] を入力して、[軽騎兵] を選択する");
                    System.out.println("[6] を入力して、[重騎兵] を選択する");
                    branchType = Integer.parseInt(reader.readLine());
                    if (branchType > 0 && branchType <= 6) {
                        break;
                    } else {
                        unCorrectInput();
                    }
                }
                // 登録完了のお知らせ
                System.out.println("新しいキャラクターを登録しました！\n" + l);
                // 兵科番号により、それぞれの対象を作り、その対象のメッセージを表示する
                if (branchType == 1) {
                    InfantryLevel1 character = new InfantryLevel1(name, level, 0, hitpoint, leadership, martial,
                            intellect);
                    character.showCharacter();
                } else if (branchType == 2) {
                    InfantryLevel2 character = new InfantryLevel2(name, level, 0, hitpoint, leadership, martial,
                            intellect);
                    character.showCharacter();
                } else if (branchType == 3) {
                    ArcherLevel1 character = new ArcherLevel1(name, level, 0, hitpoint, leadership, martial, intellect);
                    character.showCharacter();
                } else if (branchType == 4) {
                    ArcherLevel2 character = new ArcherLevel2(name, level, 0, hitpoint, leadership, martial, intellect);
                    character.showCharacter();
                } else if (branchType == 5) {
                    CavalryLevel1 character = new CavalryLevel1(name, level, 0, hitpoint, leadership, martial,
                            intellect);
                    character.showCharacter();
                } else if (branchType == 6) {
                    CavalryLevel2 character = new CavalryLevel2(name, level, 0, hitpoint, leadership, martial,
                            intellect);
                    character.showCharacter();
                } else {
                    unCorrectInput();
                }
                break;
            } else if (choosenResult.equals("N")) { // そのまま孫権を選択してプレイする場合
                // レベルがランダムで決める機能を使って、孫権の対象を作り、メッセージを表示する
                InfantryLevel1 sunquan = new InfantryLevel1("孫権", (int) (1 + Math.random() * 69 + 1), 0, 50, 83, 78,
                        82);
                sunquan.showCharacter();
                break;
            } else {
                unCorrectInput();
            }
        }
    }
}
