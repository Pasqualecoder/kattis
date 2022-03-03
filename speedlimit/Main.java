import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Kattio kattio = new Kattio();

        int rows;
        while ((rows = kattio.getInt()) != -1) {
            int[] speed = new int[rows];
            int[] time = new int[rows];

            for (int i = 0; i < rows; i++) {
                speed[i] = kattio.getInt();
                time[i] = kattio.getInt();
            }

            int miles = speed[0] * time[0];
            for (int i = 1; i < rows; i++) {
                miles += speed[i] * (time[i] - time[i-1]);
            }

            kattio.print(miles);
            kattio.println(" miles");
        }

        kattio.close();
    }

}
