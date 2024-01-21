package collections;

public class Main {
    public enum E {Planet};
    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Olympian", 8, 12);
//        theatre.getSeats();
        if(theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        if(theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        Class<? extends Theatre> c = theatre.getClass();

        E e = E.Planet;
        System.out.println(e.hashCode());
    }
}
