package exceptions;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void show() throws IOException {
        try (
                var reader = new FileReader("file.txt");
                var ignored = new FileWriter("...")
        ) {
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();

        try {
            new Account(0).withdraw(10);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
            e.printStackTrace(System.out);
        }

        System.out.println();

        try {
            new Account(0).deposit(-1);
        } catch (IOException e) {
            System.out.println("Logging");
            throw e;
        }
    }

    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }
}
