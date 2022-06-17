import java.util.*;
import java.io.*;
import java.text.BreakIterator;

public class Main {
    static Scanner fs;
    static PrintWriter pw;

    public static void solve() {
        int size = fs.nextInt();
        int[] wt = new int[size];
        int[] val = new int[size];
        for (int i = 0; i < size; i++) {
            wt[i] = fs.nextInt();
        }
        for (int i = 0; i < size; i++) {
            val[i] = fs.nextInt();
        }
        int c = fs.nextInt();
        knapsack(wt, val, c);
    }

    public static void knapsack(int[] wt, int[] val, int c) {
        double[][] r = new double[wt.length][2];
        int profit = 0;
        for (int i = 0; i < r.length; i++) {
            r[i][0] = (double) val[i] / wt[i];
            r[i][1] = i;
        }
        Arrays.sort(r, (double[] a, double[] b) -> Double.compare(a[0], b[0]));
        for (int i = r.length - 1; i > 0; i--) {
            if (c <= 0) {
                break;
            }
            int ind = (int) r[i][1];
            if (c - wt[ind] > 0) {
                c -= wt[ind];
                profit += val[ind];
            } else {
                profit += (c * r[i][0]);
                c = 0;
            }
        }
        pw.println(profit);
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
