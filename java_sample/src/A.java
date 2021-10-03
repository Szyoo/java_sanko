public class A {
    public A(int num) {
        System.out.println(num);
    }

    public static void show2() {
        System.out.println("2");
    }

    public void show1() {
        System.out.println("1");
    }

    public static void show3(int num) throws Exception {
        if (num < 10) {
            Exception e = new Exception("aa");
            throw e;
        }
    }
}
