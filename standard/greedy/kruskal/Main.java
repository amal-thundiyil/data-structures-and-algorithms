import java.util.*;
import java.io.*;

public class Main {
    static FastReader fs;
    static PrintWriter pw;
    static HashSet<Edge>[] graph;

    static class Edge {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public void addEdge(int from, int to, int weight) {
        graph[from].add(from, to, weight);
    }

    public void kruskal() {
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
