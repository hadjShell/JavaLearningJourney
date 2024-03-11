package collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Map<String, String> accountsInfo;

    @SuppressWarnings("unchecked")
    public Menu() {
        if (!Files.exists(Paths.get("data.txt")))
            accountsInfo = new HashMap<>();
        else {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"))) {
                accountsInfo = (HashMap<String, String>) in.readObject();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createAccount(String name, double balance) {
        Account newAcc = new Account(name, balance);
        accountsInfo.put(newAcc.accNum, newAcc.toString());
    }

    public boolean deleteAccount(String accNum) {
        return accountsInfo.remove(accNum) != null;
    }

    public String viewAccount(String accNum) {
        String info = accountsInfo.get(accNum);
        return info != null ? info : "Invalid account number!";
    }

    public String viewAccounts() {
        StringBuilder infos = new StringBuilder();
        accountsInfo.forEach((key, value) -> infos.append(key).append(" ").append(value).append("\n"));
        return infos.toString();
    }

    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
            out.writeObject(accountsInfo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void exit() {
        save();
        System.exit(-1);
    }

    public String toString() {
        return """
                1. Create Account
                2. Delete Account
                3. View Account
                4. View All Accounts
                5. Save Account
                6. Exit
                Enter your choice:\s""";
    }

    public static void main(String[] args) {
        Menu m = new Menu();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println(m);
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Enter name and balance: ");
                    String name = s.next();
                    double balance = s.nextDouble();
                    s.nextLine();
                    m.createAccount(name, balance);
                    break;
                }
                case 2: {
                    System.out.println("Enter your account number: ");
                    String accNum = s.next();
                    s.nextLine();
                    System.out.println(m.deleteAccount(accNum) ? "Delete successfully"
                            : "No such account");
                    break;
                }
                case 3: {
                    System.out.println("Enter your account number: ");
                    String accNum = s.next();
                    s.nextLine();
                    System.out.println(m.viewAccount(accNum));
                    break;
                }
                case 4: {
                    System.out.println(m.viewAccounts());
                    break;
                }
                case 5: {
                    m.save();
                    System.out.println("Save successfully!");
                    break;
                }
                case 6: {
                    m.exit();
                    break;
                }
                default: {
                    System.out.println("Please enter a valid number.");
                }
            }
        }
    }
}
