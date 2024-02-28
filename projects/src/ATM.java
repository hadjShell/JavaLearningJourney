// Synchronisation exercise
public class ATM {
    synchronized public void checkAmount(String name) {
        System.out.println(name + " check");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        System.out.println(name + "---");
    }

    synchronized public void withdraw(String name, int amount) {
        System.out.println(name + " withdraw " + amount);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Customer c1 = new Customer(atm, "John", 100);
        Customer c2 = new Customer(atm, "David", 200);
        c1.start();
        c2.start();

    }
}

class Customer extends Thread{
    ATM atm;
    String name;
    int amount;

    public Customer(ATM atm, String name, int amount) {
        this.atm = atm;
        this.name = name;
        this.amount = amount;
    }

    public void run() {
        useATM();
    }

    public void useATM() {
        atm.checkAmount(name);
        atm.withdraw(name, amount);
    }

}
