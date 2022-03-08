public class Main {

    public static void main(String[] args) {
        final int testCases = 1;
        for (int i = 1; i <= testCases; i++) {
            pot(i);
        }
        
    }

    public static void pot(int test) {
        // String input = "data/pot." + test + ".in";
        // String out = "data/pot." + test + ".txt";
        // String ans = "data/pot." + test + ".ans";

        // Kattio kattio = new Kattio(new FileInputStream(input), new FileOutputStream(out));

        Kattio kattio = new Kattio();
        String[] array = new String[kattio.getInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = kattio.getLine();
        }

        int somma = 0;
        for (int i = 0; i < array.length; i++) {
            String messyNum = array[i];
            int n = Integer.parseInt(messyNum.substring(0, messyNum.length()-1));
            int pow = Integer.parseInt(String.valueOf(messyNum.charAt(messyNum.length()-1)));
            somma += Math.pow(n, pow);
        }

        kattio.println(somma);
        kattio.close();

        // System.out.println("test" + test + ":\t" + FileComparator.compare(ans, out));
    }

}
