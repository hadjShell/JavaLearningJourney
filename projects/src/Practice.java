import java.lang.*;
import java.util.Arrays;

abstract class A {
    public abstract void show();
}

public class Practice {
    private static String t = "Hi";

    public static void main(String[] args) {
        String email = "john@gmail.com";
        System.out.println(Arrays.toString(email.split("@")));
        System.out.println(email.matches("(\\w+)@gmail(.+)"));
        System.out.println(checkBinaryForm("0101010110"));
        System.out.println(checkBinaryForm("12"));
        System.out.println(checkDateForm("01/12/2024"));
        System.out.println(checkDateForm("12/1/2024"));

        String str = "a!b@c#1$2%3";
        System.out.println(String.join("",str.split("\\W")));
        System.out.println(str.replaceAll("\\W", ""));

        int[] x = {1, 2, 3};
        show(x);
        show(10, 20, 30);

        System.out.println(args.length);

        test();

    }

    private static boolean checkBinaryForm(String s) {
        return s.matches("^[01]+$");
    }

    private static boolean checkDateForm(String s) {
        return s.matches("^([0-3][0-9])/([0-1][0-9])/(\\d{4})$");
    }

    private static void show(int... x) {
        for (int e : x) {
            System.out.println(e);
        }
    }

    static public void test() {
        int i = 100;
        A a = new A(){
            public void show() {
                System.out.println(i);
                System.out.println(t);
            }
        };
        a.show();
    }
}
