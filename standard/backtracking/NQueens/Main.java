import java.util.*;
import java.io.*;

public class Main {
    static FastReader fs;
    static PrintWriter pw;

    public static List<List<int[]>> solveNQueens(int n) {
        List<List<int[]>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<int[]> temp = new ArrayList<>();
                temp.add(new int[] { i, j });
                dfs(ans, temp, n);
            }
        }

        for (List<int[]> sol : ans) {
            for (int[] arr : sol) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("");
        }
        return ans;
    }

    public static void dfs(List<List<int[]>> ans, List<int[]> temp, int n) {
        if (temp.size() == n) {
            ans.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isValidPostition(temp, i, j)) {
                    continue;
                }
                temp.add(new int[] { i, j });
                dfs(ans, temp, n);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isValidPostition(List<int[]> temp, int i, int j) {
        for (int[] pos : temp) {
            int a = pos[1] - j, b = pos[0] - i;
            if (a == 0 || b == 0 || a == b)
                return false;
        }
        return true;
    }

    public static void solve() {
        solveNQueens(4);
    }

    public static void main(String args[]) throws Exception {
        System.setErr(new PrintStream("error.txt"));
        fs = new FastReader();
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

        public FastReader() {
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