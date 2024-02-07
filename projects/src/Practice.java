import java.lang.*;

public class Practice {
    public static void main(String[] args) {
        testStack();
    }

    private static boolean checkBinaryForm(String s) {
        return s.matches("^[01]+$");
    }

    private static boolean checkDateForm(String s) {
        return s.matches("^([0-3][0-9])/([0-1][0-9])/(\\d{4})$");
    }

    private static void testStack() {
        Stack s = new Stack();
        System.out.println(s.pop());
        System.out.println("---");
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println("---");
        s.push(6);
        System.out.println("---");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println("---");
        System.out.println(s.pop());
    }
}
