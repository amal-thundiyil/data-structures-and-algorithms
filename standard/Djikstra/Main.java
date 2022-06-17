import java.util.*;
import java.io.*;

public class Main {
    static Scanner fs;
    static PrintWriter pw;

    public static void djikstra(int[][] graph, int s) {
        Boolean[] vis = new Boolean[graph.length];
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            vis[i] = false;
        }

        dist[s] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            int u = min(dist, vis);
            vis[u] = true;

            for (int v = 0; v < graph.length; v++) {
                if (vis[v] != true && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                }
            }
        }
        pw.println(Arrays.toString(dist));
    }

    public static int min(int[] dist, Boolean[] vis) {
        int m = Integer.MAX_VALUE, ind = -1;
        for (int v = 0; v < dist.length; v++) {
            if (vis[v] == false && dist[v] <= m) {
                m = dist[v];
                ind = v;
            }
        }
        return ind;
    }

    public static void solve() {
        int s = fs.nextInt();
        int m = fs.nextInt();
        int n = fs.nextInt();
        int[][] graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = fs.nextInt();
            }
        }
        djikstra(graph, s);
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
