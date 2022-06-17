import java.util.*;
import java.io.*;

public class Main {
    static Scanner fs;
    static PrintWriter pw;

    public static double genHash(String ptn) {
        double hash = 0;
        for (char c : ptn.toCharArray()) {
            hash += Math.pow(2, (c - 'a'));
        }
        return hash;
    }

    public static void rabinKarp(String txt, String ptn, double h) {
        double hash = 0;
        List<String> res = new ArrayList<>();
        for (int lo = 0, hi = 0; hi < txt.length(); hi++) {
            hash += Math.pow(2, txt.charAt(hi) - 'a');
            if ((hi - lo + 1) == ptn.length()) {
                if (hash == h) {
                    int i = lo;
                    for (i = lo; i <= hi; i++) {
                        if (txt.charAt(i) != ptn.charAt(i - lo)) {
                            break;
                        }
                    }
                    if (i > hi) {
                        pw.println("Found match at: " + lo + " index");
                        res.add(txt.substring(lo, hi + 1));
                    }
                }
                lo++;
                hash -= Math.pow(2, txt.charAt(lo) - 'a');
            }
        }
        pw.println(res.toString());
    }

    public static void solve() {
        String txt = fs.nextLine();
        String ptn = fs.nextLine();
        double h = genHash(ptn);
        rabinKarp(txt, ptn, h);
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
