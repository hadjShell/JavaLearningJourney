import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
    int j=12;
    void add()
    {
        j=j+12;
        System.out.println("J="+j);
    }

    @Override
    public void finalize()
    {
        System.out.println("Object is garbage collected");
    }

    public static void main(String[] args) throws Exception {
        new Practice().add();
        System.gc();
        new Practice().add();
        System.out.println(Runtime.getRuntime().totalMemory());
        List<Integer> l = Arrays.asList(1, 2, 3);
        l.forEach(System.out::println);
        System.out.println(l.stream().reduce(0, Integer::sum));
        StringBuffer sb = new StringBuffer("Java Code");
        System.out.println(sb.capacity());
        sb.trimToSize();
        System.out.println(sb.capacity());
    }
}