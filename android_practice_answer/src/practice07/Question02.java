package practice07;

public class Question02 {

	public static void main(String[] args) {
		Nyosu nyosu = new Nyosu();

		nyosu.bark();

		nyosu.setAttack("ねこキック");
		nyosu.setDefense("ふて寝");

		System.out.println("ニョースの" + nyosu.getAttack() + "\n大ダメージだ！");
		System.out.println("ニョースの" + nyosu.getDefense() + "\n防御力が上がった！");

	}

}
