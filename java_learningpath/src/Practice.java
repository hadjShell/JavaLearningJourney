import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Practice {


    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<String>();
        l.add("Hello");
        String[] a = new String[l.size()];
        a = l.toArray(a);
    }
}
