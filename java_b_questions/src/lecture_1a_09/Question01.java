package lecture_1a_09;

public class Question01 {
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.attack("火を吹く");
        dragon.attack("尻尾ではたく", 3);
    }
}
