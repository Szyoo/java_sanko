package practice04;

public class Question04 {

	public static void main(String[] args) {
		int[] randomNum = { 1, 3, 5, 4, 2, 10, 9, 8, 6, 7 };
		System.out.println("計算を始めます");
		int sum = randomNum[0];

		for (int i = 0; i < randomNum.length; i++) {
			System.out.println(sum);
			sum += randomNum[i + 1];
			if (sum > 20) {
				System.out.println(sum);
				System.out.println("合計が20を超えたので計算を終了します");
				break;
			}
		}
	}

}
