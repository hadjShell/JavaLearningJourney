public class TestThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("HI");
        }
    }

    public static void main(String[] args) {
        TestThread t = new TestThread();
        t.start();
        while (true) {
            System.out.println("WORLD");
        }
    }
}
