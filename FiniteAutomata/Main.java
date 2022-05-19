import java.util.*;
import java.io.*;

public class Main {
    static Scanner fs;
    static PrintWriter pw;

    public static void solve() {
        String txt = fs.nextLine();
        String ptn = fs.nextLine();
        int[] lps = new int[ptn.length()];
        finiteAutomata(ptn, lps);
        finiteAutomata(txt, ptn, lps);
    }

    public static void main(String[] args) throws Exception {
        // System.setErr(new PrintStream("error.txt"));
        System.setIn(new FileInputStream("input.txt"));
        fs = new Scanner(System.in);
        pw = new PrintWriter(System.out, true);
        int t = fs.nextInt();
        fs.nextLine();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }
}