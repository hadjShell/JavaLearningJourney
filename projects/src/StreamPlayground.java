import java.io.*;
import java.util.Arrays;
import java.util.UUID;

public class StreamPlayground {
    public static void main(String[] args) throws Exception {
        System.out.println(System.in.getClass());
    }

    private static void copyFile(String path) throws IOException {
        try (FileReader in = new FileReader(path);
             StringWriter out = new StringWriter()) {

            in.transferTo(out);
            System.out.println(out);
        }
    }

    private static void copyByteArray() throws IOException {
        byte[] b = {'a', 'b', 'c', 'd', 'e', 'f'};

        try (ByteArrayInputStream in = new ByteArrayInputStream(b);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.out.println(in.transferTo(out));
            //out.writeTo(System.out);
            System.out.println(Arrays.toString(out.toByteArray()));
            System.out.write(97);
            System.out.flush();
        }
    }

    private static void consoleTest() {
        // Not working in IDE
        Console c = System.console();
        System.out.println(c);
        String login = c.readLine("Enter your login: ");
        char [] password = c.readPassword("Enter your password: ");
        System.out.println(login);
        System.out.println(String.valueOf(password));
    }

    private static void serialAndDeserialDoubleArray() throws Exception {
        double[] arr = {1.2, 1.3, 1.4, 1.5};
        String path = "/Users/hadjshell/Desktop/data.txt";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(arr);
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            double[] arr2 = (double[]) in.readObject();
            System.out.println(Arrays.toString(arr2));
        }
    }

    private static void seDesCustomer() throws Exception {
        Customer c1 = new Customer("David", "1234");
        Customer c2 = new Customer("John", "5678");
        String path = "/Users/hadjshell/Desktop/data.txt";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(c1);
            out.writeObject(c2);
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            Customer c3 = (Customer) in.readObject();
            Customer c4 = (Customer) in.readObject();
            System.out.println(c3);
            System.out.println(c4);
        }
    }

    private static class Customer implements Serializable {
        private String cID;
        private String name;
        private String phone;

        public Customer() {}

        public Customer(String name, String phone) {
            cID = String.valueOf(UUID.randomUUID());
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return String.format("ID: %s%nName: %s%nPhone: %s", cID, name, phone);
        }
    }
}
