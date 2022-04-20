package practice07;

public class Nyosu extends Hogemon{

	@Override
	public String getAttack() {
		return super.getAttack() + "\n大ダメージだ！";
	}

	@Override
	public void bark(){
		System.out.println("にょにょ！");
	}
}
