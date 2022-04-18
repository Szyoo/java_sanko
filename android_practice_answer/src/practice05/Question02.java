package practice05;

public class Question02 {

	public static void main(String[] args) {
		//自分で作成した解答は「Dragon dragon = new Dragon()」となっているはずです。
		Dragon02 dragon = new Dragon02();

		dragon.attack();

		dragon.attack("火を吹く");

		dragon.attack("尻尾ではたく", 3);
	}

}
