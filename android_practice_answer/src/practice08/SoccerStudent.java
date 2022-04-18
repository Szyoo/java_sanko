package practice08;

public class SoccerStudent implements StudyingPerson, SportsPerson {

	@Override
	public void playSports() {
		System.out.println("サッカーを毎日します");

	}

	@Override
	public void study() {
		System.out.println("毎日勉強します");

	}

}
