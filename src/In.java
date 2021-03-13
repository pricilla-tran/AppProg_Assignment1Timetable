import java.util.*;

public class In {
    /**
     * A singleton instance of Scanner used for reading all input
     * from STDIN.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * The constructor is private because no instances of this
     * class should be created. All methods are static and can
     * be directly invoked on the class itself.
     */
    private In() {}

    /**
     * Read the next line of text.
     *
     * @return the line as a String
     */
    public static String nextLine() {
        return scanner.nextLine();
    }

    /**
     * Read the next line as an integer.
     *
     * @return the integer that was read
     */
    public static int nextInt() {
        int value = scanner.nextInt();
        scanner.nextLine(); // read the "\n" as well
        return value;
    }

    /**
     * Read the next line as a double.
     *
     * @return the double that was read
     */
    public static double nextDouble() {
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    /**
     * Read the first character of the next line of text.
     *
     * @return the character that was read
     */
    public static char nextChar() {
        return scanner.nextLine().charAt(0);
    }
}
