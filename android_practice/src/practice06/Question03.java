package practice06;

public class Question03 {

	public static void main(String[] args) {
		Child child1 = new Child("鈴木ゆうな", 5);
		Child child2 = new Child("上田虎太郎");
		Child child3 = new Child();

		System.out.println("child1\n名前：" + child1.getName() + "\n年齢：" + child1.getAge());
		System.out.println("child2\n名前：" + child2.getName() + "\n年齢：" + child2.getAge());
		System.out.println("child3\n名前：" + child3.getName() + "\n年齢：" + child3.getAge());
	}
}
