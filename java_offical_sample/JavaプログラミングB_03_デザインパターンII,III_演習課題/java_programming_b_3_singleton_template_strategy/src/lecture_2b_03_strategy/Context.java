package lecture_2b_03_strategy;

public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		setStrategy(strategy);
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public String contextMethod() {
		return strategy.strategyMethod();
	}
}
