package lecture_3a_07;

public class Question3 {
    public static void main(String[] args) {
        Human human = new Human();
        human.setAge(25);
        human.setName("鈴木加奈子");
        System.out.println(human.getName() + "の10年後の年齢は" + human.futureAge() + "歳です");
    }
}
