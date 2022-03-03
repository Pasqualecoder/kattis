import java.io.*;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Kattio io = new Kattio();

        int[] array = new int[io.getInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = io.getInt();
        }

        for (int i = array.length - 1; i >= 0; i--) {
            io.println(array[i]);
        }

        io.close();
    }

}
