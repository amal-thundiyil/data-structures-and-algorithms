import java.util.*;
import java.io.*;

public class Main {
    static Scanner fs;
    static PrintWriter pw;

    public static void display(List<int[][]> ans) {
        for (int[][] mat : ans) {
            for (int i = 0; i < mat.length; i++) {
                pw.println(Arrays.toString(mat[i]));
            }
        }
    }

    public static void display(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            pw.println(Arrays.toString(mat[i]));
        }
        pw.println("");
    }

    public static void bb(int[][] mat, int[][] vis, List<int[][]> temp, List<int[][]> ans, int i, int j, int c) {
        if (c == 0) {
            for (int[][] a : temp) {
                ans.add(a);
            }
            return;
        }
        int c1, c2, c3, c4;
        c1 = c2 = c3 = c4 = Integer.MAX_VALUE;
        if (i - 1 > 0 && vis[i - 1][j] != 1) {
            swap(mat, i, j, i - 1, j);
            c1 = h(mat);
            swap(mat, i, j, i - 1, j);
        }
        if (i + 1 > 0 && vis[i + 1][j] != 1) {
            swap(mat, i, j, i + 1, j);
            c2 = h(mat);
            swap(mat, i, j, i + 1, j);
        }
        if (j - 1 > 0 && vis[i][j - 1] != 1) {
            swap(mat, i, j, i, j - 1);
            c3 = h(mat);
            swap(mat, i, j, i, j - 1);
        }
        if (j + 1 > 0 && vis[i][j + 1] != 1) {
            swap(mat, i, j, i, j + 1);
            c4 = h(mat);
            swap(mat, i, j, i, j + 1);
        }
        vis[i][j] = 1;
        c = Math.min(Math.min(c1, c2), Math.min(c3, c4));
        if (c == Integer.MAX_VALUE) {
            return;
        }
        findMinMatrix(c, c1, c2, c3, c4, mat, i, j, temp);
        bb(mat, vis, temp, ans, i, j, c);
    }

    public static void swap(int[][] mat, int a1, int a2, int b1, int b2) {
        mat[a1][a2] ^= mat[b1][b2];
        mat[b1][b2] ^= mat[a1][a2];
        mat[a1][a2] ^= mat[b1][b2];
    }

    public static void findMinMatrix(int c, int c1, int c2, int c3, int c4, int[][] mat, int i, int j,
            List<int[][]> temp) {
        if (c1 == c) {
            swap(mat, i, j, i - 1, j);
            temp.add(mat);
        } else if (c2 == c) {
            swap(mat, i, j, i + 1, j);
            temp.add(mat);
        } else if (c3 == c) {
            swap(mat, i, j, i, j - 1);
            temp.add(mat);
        } else if (c4 == c) {
            swap(mat, i, j, i, j + 1);
            temp.add(mat);
        }
    }

    public static int h(int[][] mat) {
        int c = 0, count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                count++;
                if (mat[i][j] != -1 && mat[i][j] != 0 && count != mat[i][j]) {
                    c++;
                }
            }
        }
        return c;
    }

    public static void solve() {
        int m = fs.nextInt();
        int n = fs.nextInt();
        int mat[][] = new int[m][n];
        int vis[][] = new int[m][n];
        List<int[][]> ans = new ArrayList<>();
        List<int[][]> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = fs.nextInt();
            }
        }
        int[] arr = new int[2];
        initalPosn(mat, arr);
        display(mat);
        bb(mat, vis, temp, ans, arr[0], arr[1], h(mat));
        display(ans);
    }

    public static void initalPosn(int[][] mat, int[] arr) {
        for (int i = mat.length - 1; i > 0; i--) {
            for (int j = mat[i].length - 1; j > 0; j--) {
                if (mat[i][j] == 0) {
                    arr[0] = i;
                    arr[1] = j;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setErr(new PrintStream("error.txt"));
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
