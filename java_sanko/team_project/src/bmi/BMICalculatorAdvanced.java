package bmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*
 * チームメンバー：
 *			楊聖哲
 *			月坂恵介
 */

public class BMICalculatorAdvanced {

	public static void main(String[] args) throws IOException {
		boolean restart = false;// 再起動しない前提であることを示すフラグ
		lableA: do {
			// BMI計算式で使う変数を宣言
			int manNumber; // 計算したい人数
			boolean WriteHeightInCm = false; // 身長がcm表記前提であることを示すフラグ
			boolean isFatExist = false;// 肥満の人がいない前提であることを示すフラグ
			boolean isLowWeightExist = false;// 低体重の人がいない前提であることを示すフラグ
			String outputContent = ""; // 標準出力文字列
			DecimalFormat df = new DecimalFormat("#.00");

			// キーボードからの標準入力を受け付け
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("-----------------------\nBMIを計算したい人数を数字で入力してください。");
				// 標準入力されたものを文字列として読み込むして、数値（int型変数）に変換
				manNumber = Integer.parseInt(reader.readLine());
				if (manNumber > 4 || manNumber < 1) {
					System.out.println("1から4まで以外の数字まだは内容を入力しました、もう一度正しく入力してください。");
				} else {
					break;
				}
			} while (true);

			// BMI計算式で使う配列を宣言
			double[] height = new double[manNumber]; // 身長の配列
			double[] weight = new double[manNumber]; // 体重の配列 (kg)
			double[] bmi = new double[manNumber]; // BMIの配列(計算結果)
			double[] standardWeight = new double[manNumber]; // 適正体重の配列

			do {
				System.out.println("-----------------------\n身長をcmで入力したい場合は「1」を、mで入力したい場合は「2」を入力してください。");
				int options = Integer.parseInt(reader.readLine()); // 標準入力されたものを文字列として読み込む、数値（int型変数）に変換
				if (options == 1) {
					WriteHeightInCm = true;
					outputContent = "の身長を入力してください（cm）。";
					break;
				} else if (options == 2) {
					WriteHeightInCm = false;
					outputContent = "の身長を入力してください（m）。";
					break;
				} else {
					System.out.println("不適切な入力がされました。もう一度正しく入力してください。");
				}
			} while (true);

			// 人数を対応して、身長と体重を読み込みして、BMIを計算する
			for (int i = 0; i < manNumber; i++) {
				do {
					System.out.println("-----------------------\n" + (i + 1) + "人目の方" + outputContent);
					// 標準入力されたものを文字列として読み込みして、数値（double型変数）に変換して、配列に保存する
					height[i] = Double.parseDouble(reader.readLine());
					if (WriteHeightInCm) {
						// 身長はcmからmに変換
						height[i] *= 0.01;
					}
					if (height[i] > 2.72 || height[i] < 0.6) { // ギネス記録身長0.6m~2.72ｍ
						System.out.println("不適切な入力がされました。もう一度正しく入力してください。");
					} else {
						break;
					}
				} while (true);

				do {
					System.out.println((i + 1) + "人目の方の体重を入力してください（kg）。");
					// 標準入力されたものを文字列として読み込みして、数値（double型変数）に変換して、配列に保存する
					weight[i] = Double.parseDouble(reader.readLine());
					if (weight[i] > 635 || weight[i] < 4.5) { // ギネス記録体重4.5kg~635kg
						System.out.println("不適切な入力がされました。もう一度正しく入力してください。");
					} else {
						break;
					}
				} while (true);

				// BMIを計算する〔計算式：体重(kg) ÷ ( 身長(m) x 身長(m) )〕
				bmi[i] = weight[i] / Math.pow(height[i], 2);

				// BMIから肥満判定をして、低体重まだは肥満の人があるかどうか判断する
				if (bmi[i] >= 25) {
					isFatExist = true;
				}
				if (bmi[i] < 18.5) {
					isLowWeightExist = true;
				}
			}

			// 入力する完了後BMIと適正体重の結果を標準出力
			System.out.println("-----------------------\n計算中...少々お待ちください。\n.\n.\n計算結果は以下の通り");
			for (int i = 0; i < manNumber; i++) {
				// BMI値を標準出力
				System.out.println("-----------------------\n" + (i + 1) + "人目の方のBMIは" + df.format(bmi[i]) + "です。");

				// 適正体重を計算し、体重との差を標準出力（体重より±かでメッセージが分岐）
				standardWeight[i] = Math.pow(height[i], 2) * 22;
				if (standardWeight[i] - weight[i] > 0) {
					System.out.println(
							(i + 1) + "人目の方の体重は適正体重より" + df.format(standardWeight[i] - weight[i]) + "kg少ないです。");
				} else {
					System.out
							.println((i + 1) + "人目の方の体重は適正体重より" + df.format(weight[i] - standardWeight[i]) + "kg多いです。");
				}
			}

			// 肥満と低体重結果を標準出力
			outputContent = "。体重をつけてください。";
			if (isLowWeightExist) {
				if (manNumber > 1) {
					outputContent = "-----------------------\n低体重の方がいらっしゃいます" + outputContent;
				} else {
					outputContent = "-----------------------\nあなたは低体重です" + outputContent;
				}
				System.out.println(outputContent);
			}
			outputContent = "。体重を減らしましょう。";
			if (isFatExist) {
				if (manNumber > 1) {
					outputContent = "肥満の方がいらっしゃいます" + outputContent;
				} else {
					outputContent = "あなたは肥満です" + outputContent;
				}
				System.out.println(outputContent);
			}

			boolean inputUncorrect = false; // 入力正しくない前提であることを示すフラグ
			do {
				System.out.println(
						"-----------------------\nBMI計算を再度行いますか？\nBMI計算を再度行い場合は「Y」を、BMI計算を再度行わない場合は「N」を入力してください。");
				String option1 = reader.readLine();
				if (option1.equals("Y")) {
					restart = true;
					break;
				} else if (option1.equals("N")) {
					restart = true;
					System.out.println("BMI計算プログラムを終了します。");
					break lableA;
				} else {
					System.out.println("不適切な入力がされました。もう一度正しく入力してください。");
					inputUncorrect = true;
				}
			} while (inputUncorrect);
		} while (restart);
	}
}
