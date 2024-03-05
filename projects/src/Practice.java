import java.lang.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class Practice {
    public static void main(String[] args) throws Exception {
        Path p = Paths.get("foo");
        System.out.println(p.toAbsolutePath());
        System.out.println(p.toRealPath());

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
