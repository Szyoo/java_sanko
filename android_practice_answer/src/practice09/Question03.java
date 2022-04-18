package practice09;

public class Question03 {

	public static void main(String[] args) {
		int[] nums1 = {2, 10, 9, 8, 7};

		int[] nums2 = {1, 5, 3, 0};

		try {
			for (int i = 0; i < nums1.length; i++) {
				int result = nums1[i]/nums2[i];
				System.out.println("nums1[" + i + "]/nums2[" + i + "]="  + result);
			}
		} catch (ArithmeticException e) {
			System.out.println("0で割りました");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("配列の要素数が足りません");
		} finally {
			System.out.println("処理を終了しました");
		}



	}

}
