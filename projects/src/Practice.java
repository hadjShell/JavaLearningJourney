import java.lang.*;
import java.lang.annotation.Native;

public class Practice {

    @Native
    public static void main(String[] args) {
        Practice.show();
    }

    private static boolean checkBinaryForm(String s) {
        return s.matches("^[01]+$");
    }

    private static boolean checkDateForm(String s) {
        return s.matches("^([0-3][0-9])/([0-1][0-9])/(\\d{4})$");
    }

    @Deprecated(since = "1.1")
    public static void show() {
        System.out.println("Hi");
    }
}
