package collections;

import java.io.Serializable;
import java.util.UUID;

public class Account implements Serializable {
    String accNum;
    String name;
    double balance;

    public Account() {}

    public Account(String name, double balance) {
        accNum = String.valueOf(UUID.randomUUID());
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return name + ", " + balance;
    }
}
