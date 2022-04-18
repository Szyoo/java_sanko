package practice04;

public class Question04 {
	
	public static void main(String[] args) {
		int[] randomNum = {1, 9, 4, 5, 7, 8, 2, 6, 3, 10};
		
		System.out.println("計算を始めます");
		int sum = randomNum[0];
		
		for(int i = 0; i < randomNum.length; i++ ) {
			System.out.println(sum);
			sum += randomNum[i+1];
			
			if(sum > 20) {
				System.out.println(sum);
				System.out.println("合計が20を超えたので計算を終了します");
				break;
			}	
		}
	}

}
