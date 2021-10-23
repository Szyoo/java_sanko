package lecture_1b_03_templateMethod;

public abstract class AbstractClass {

	public final void templateMethod() {
		methodA();
		methodB();
	}

	protected abstract void methodA();
	protected abstract void methodB();

}
