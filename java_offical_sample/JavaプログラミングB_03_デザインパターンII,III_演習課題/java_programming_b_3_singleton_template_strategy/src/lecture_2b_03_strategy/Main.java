package lecture_2b_03_strategy;

public class Main {
	public static void main(String[] args) {
		Context context = new Context(new ConcreteStrategyA());
		System.out.println(context.contextMethod());

		context.setStrategy(new ConcreteStrategyB());
		System.out.println(context.contextMethod());
	}
}
