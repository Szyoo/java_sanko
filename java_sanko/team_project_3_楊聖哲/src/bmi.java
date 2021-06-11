import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class bmi {
    private double height; // 身長
    private double weight; // 体重(kg)
    private double bmi; // BMI(計算結果)
    private double standardWeight; // 適正体重

    public bmi() {
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getStandardWeight() {
        return standardWeight;
    }

    public void setStandardWeight(double standardWeight) {
        this.standardWeight = standardWeight;
    }

    public void showInputData() {
        System.out.println("あなたの身長は:" + getHeight());
        System.out.println("あなたの体重は:" + getWeight());
    }

    public void runBMIAdvance() throws NumberFormatException, IOException {
        recordHeight(choseLength());
        recordWeight();
        // showInputData();
        calculate();
        showBMI();
        showStandardWeightGap();
        showFatJudgement();
    }

    private boolean choseLength() throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        do {
            System.out.println("-----------------------\n身長をcmで入力したい場合は数字「1」を、mで入力したい場合は数字「2」を入力してください。");
            int options = Integer.parseInt(reader.readLine()); // 標準入力されたものを文字列として読み込む、数値（int型変数）に変換
            if (options == 1) {
                flag = true;
                System.out.println("あなたの身長を入力してください（cm）。");
                break;
            } else if (options == 2) {
                flag = false;
                System.out.println("あなたの身長を入力してください（m）。");
                break;
            } else {
                System.out.println("不適切な入力がされました。もう一度正しく入力してください。");
            }
        } while (true);
        return flag;
    }

    private void recordHeight(boolean flag) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double height;
        do {
            // 標準入力されたものを文字列として読み込みして、数値（double型変数）に変換して、配列に保存する
            height = Double.parseDouble(reader.readLine());
            if (flag) {
                // 身長はcmからmに変換
                height *= 0.01;
            }
            if (height > 2.72 || height < 0.6) { // ギネス記録身長0.6m~2.72ｍ
                System.out.println("不適切な入力がされました。もう一度正しく入力してください。");
            } else {
                break;
            }
        } while (true);
        setHeight(height);
    }

    private void recordWeight() throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double weight;
        do {
            System.out.println("あなたの体重を入力してください（kg）。");
            // 標準入力されたものを文字列として読み込みして、数値（double型変数）に変換して、配列に保存する
            weight = Double.parseDouble(reader.readLine());
            if (weight > 635 || weight < 4.5) { // ギネス記録体重4.5kg~635kg
                System.out.println("不適切な入力がされました。もう一度正しく入力してください。");
            } else {
                break;
            }
        } while (true);
        setWeight(weight);
    }

    private void calculate() {
        double w = getWeight();
        double h = getHeight();
        setBmi(w / Math.pow(h, 2));
        setStandardWeight(Math.pow(h, 2) * 22);
    }

    private void showFatJudgement() {
        // BMIから肥満判定をして、低体重まだは肥満の人があるかどうか判断する
        double b = getBmi();
        if (b >= 25) {
            System.out.println("肥満判定によって、あなたは肥満です。\n体重を減らしましょう");
        } else if (b < 18.5) {
            System.out.println("肥満判定によって、あなたは低体重です。\n体重をつけてください。");
        } else if (b > 0) {
            System.out.println("肥満判定によって、あなたは正常です。おめでとうございます。");
        } else {
            System.out.println("不適切な入力がされました。もう一度検査してください。");
        }
    }

    private void showStandardWeightGap() {
        double s = getStandardWeight();
        double w = getWeight();
        DecimalFormat df = new DecimalFormat("#.00");
        // 適正体重と体重の差を標準出力（体重より±かでメッセージが分岐）
        if (s - w > 0) {
            System.out.println("あなたの体重は適正体重より" + df.format(s - w) + "kg少ないです。");
        } else if (s - w < 0) {
            System.out.println("あなたの体重は適正体重より" + df.format(w - s) + "kg多いです。");
        } else if ((s != 0) && (s - w == 0)) {
            System.out.println("あなたの体重は適正体重と同じです。");
        } else {
            System.out.println("不適切な入力がされました。もう一度検査してください。");
        }
    }

    private void showBMI() {
        double b = getBmi();
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("あなたのBMIは" + df.format(b) + "です。");
    }
}
