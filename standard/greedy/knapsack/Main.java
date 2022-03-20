import java.util.*;
import java.io.*;

public class Main {
    static FastReader fs;
    static PrintWriter pw;

    public void knapsack(int wt[], int c[], int W, int n) {
        int ans[][] = new int[n + 1][W + 1];
        int i = 0, w = 0;
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    ans[i][w] = 0;
                } else if (wt[i - 1] <= W) {
                    ans[i][w] = Math.max(c[i - 1] + ans[i - 1][w - wt[i - 1]], ans[i - 1][w]);
                } else {
                    ans[i][w] = ans[i - 1][w];
                }
            }
        }

        int res = ans[n][W];
        System.out.println(res);

        for (w = W, i = n; i > 0 && res > 0; i--) {
            if (res == ans[i - 1][w])
                continue;
            else {
                System.out.print(wt[i - 1] + " ");
                res = res - val[i - 1];
                w = w - wt[i - 1];
            }
        }
    }

    public static void solve() {
    }

    public static void main(String args[]) throws Exception {
        System.setErr(new PrintStream("error.txt"));
        fs = new Reader();
        pw = new PrintWriter(System.out);
        int t = 1;
        t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public fastReader() {
            try {
                br = new BufferedReader(
                        new FileReader("input.txt"));
                PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            } catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
