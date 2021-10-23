package lecture_1b_03_templateMethod;

public class ConcreteClass extends AbstractClass {

	@Override
	public void methodA() {
		System.out.println("methodAを実行");
	}

	@Override
	public void methodB() {
		System.out.println("methodBを実行");
	}

}
