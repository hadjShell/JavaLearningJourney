import java.lang.*;

public class Practice {
    public static void main(String[] args) {
        System.out.println("Hi");
    }

    private static boolean checkBinaryForm(String s) {
        return s.matches("^[01]+$");
    }

    private static boolean checkDateForm(String s) {
        return s.matches("^([0-3][0-9])/([0-1][0-9])/(\\d{4})$");
    }

}
