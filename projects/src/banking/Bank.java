package banking;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name) {
        if(findBranch(name) == null) {
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        Branch b = findBranch(branchName);
        if(b != null) {
            return b.newCustomer(customerName, transaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch b = findBranch(branchName);
        if(b != null) {
            return b.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

    public boolean listCustomers(String name, boolean printTransaction) {
        Branch b = findBranch(name);
        if(b != null) {
            System.out.println("Customer details for branch " + b.getName());
            ArrayList<Customer> cList = b.getCustomers();
            for(int i = 0; i < cList.size(); i++) {
                System.out.printf("Customer: %s[%d]\n", cList.get(i).getName(), i + 1);
                if(printTransaction) {
                    ArrayList<Double> tList = cList.get(i).getTransactions();
                    System.out.println("Transactions");
                    for(int j = 0; j < tList.size(); j++) {
                        System.out.printf("[%d] Amount %.2f\n", j + 1, tList.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }

    private Branch findBranch(String name) {
        for (Branch b : branches) {
            if(b.getName().equals(name))
                return b;
        }
        return null;
    }
}
