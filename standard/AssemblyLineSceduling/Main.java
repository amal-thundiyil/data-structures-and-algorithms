import java.util.*;
import java.io.*;

public class Main {
    static Scanner fs;
    static PrintWriter pw;

    public static void solve() {
        int len = fs.nextInt();
        int[] e1 = new int[2]; // entry, exit
        int[] e2 = new int[2];
        int[] line1 = new int[len];
        int[] line2 = new int[len];
        int[] line1to2 = new int[len];
        int[] line2to1 = new int[len];

        for (int i = 0; i < 2; i++) {
            e1[i] = fs.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            e2[i] = fs.nextInt();
        }
        for (int i = 0; i < len; i++) {
            line1[i] = fs.nextInt();
        }
        for (int i = 0; i < len; i++) {
            line2[i] = fs.nextInt();
        }
        for (int i = 0; i < len; i++) {
            line1to2[i] = fs.nextInt();
        }
        for (int i = 0; i < len; i++) {
            line2to1[i] = fs.nextInt();
        }

        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = e1[0] + line1[0];
        dp2[0] = e2[0] + line2[0];

        for (int i = 1; i < len; i++) {
            dp1[i] = Math.min(dp2[i - 1] + line2to1[i] + line1[i], dp1[i - 1] + line1[i]);
            dp2[i] = Math.min(dp1[i - 1] + line1to2[i] + line2[i], dp2[i - 1] + line2[i]);
        }
        int ans = Math.min(dp1[len - 1] + e1[1], dp2[len - 1] + e2[1]);
        pw.println(ans);
    }

    public static void main(String[] args) throws Exception {
        // System.setErr(new PrintStream("error.txt"));
        System.setIn(new FileInputStream("input.txt"));
        fs = new Scanner(System.in);
        pw = new PrintWriter(System.out, true);
        int t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }
}
