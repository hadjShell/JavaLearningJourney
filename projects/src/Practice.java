import java.lang.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class Practice {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("LLLL dd y E hh:mm:ss");
        System.out.println(dt.format(dtf));
        System.out.println(dt.getChronology());

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
