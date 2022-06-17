import java.util.*;
import java.io.*;

public class Main {
    static Scanner fs;
    static PrintWriter pw;

    public static void kmp(String txt, String ptn, int[] lps) {
        List<String> res = new ArrayList<>();
        int t = 0, p = 0;
        while (t < txt.length()) {
            if (ptn.charAt(p) == txt.charAt(t)) {
                p++;
                t++;
            }
            if (p == ptn.length()) {
                System.out.println("Found pattern "
                        + "at index " + (t - p));
                res.add(txt.substring(t - p, t));
                p = lps[p - 1];
            } else if (t < txt.length() && ptn.charAt(p) != txt.charAt(t)) {
                if (p != 0)
                    p = lps[p - 1];
                else
                    t = t + 1;
            }
        }
        pw.println(res.toString());
    }

    public static void genLps(String ptn, int[] lps) {
        int lo = 0, hi = 1;
        lps[0] = 0;
        while (hi < lps.length) {
            if (ptn.charAt(lo) == ptn.charAt(hi)) {
                lps[hi++] = ++lo;
            } else if (lo == 0) {
                lps[hi++] = 0;
            } else {
                lo = lps[lo - 1];
            }
        }
    }

    public static void solve() {
        String txt = fs.nextLine();
        String ptn = fs.nextLine();
        int[] lps = new int[ptn.length()];
        genLps(ptn, lps);
        kmp(txt, ptn, lps);
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
