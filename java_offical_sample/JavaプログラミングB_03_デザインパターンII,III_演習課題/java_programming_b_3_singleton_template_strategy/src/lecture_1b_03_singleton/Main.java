package lecture_1b_03_singleton;

public class Main {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		if (obj1 == obj2) {
			System.out.println("obj1とobj2は同じインスタンスです（同じメモリの箇所に存在）。");
		} else {
			System.out.println("obj1とobj2は同じインスタンスではありません（メモリ上、別々に存在）。");
		}
	}

}
