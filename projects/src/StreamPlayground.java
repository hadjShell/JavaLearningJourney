import java.io.*;
import java.util.Arrays;

public class StreamPlayground {
    public static void main(String[] args) throws IOException {

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
}
