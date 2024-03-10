import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CollectionPlayground {
    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 2, 3, 4);
        System.out.println(l1.getClass());
        ArrayList<Integer> a1 = new ArrayList<>(l1);
        System.out.println(a1.get(0));
        System.out.println(a1.remove(0));
        System.out.println(a1);
//        ListIterator<Integer> li = a1.listIterator();
//        System.out.println(li.nextIndex());
//        System.out.println(li.next());
//        System.out.println(li.nextIndex());
//        System.out.println(li.previousIndex());
//        System.out.println(li.previous());
//        System.out.println(li.previous());
        a1.forEach(CollectionPlayground::show);
    }

    public static void show(int n) {
        System.out.println(n);
    }
}
