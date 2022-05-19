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

    public static void bb(int[][] mat, List<int[][]> temp, List<int[][]> ans, int i, int j, int c) {
        if (c == 0) {
            for (int[][] a : temp) {
                ans.add(a);
            }
            return;
        }
        int c1, c2, c3, c4;
        c1 = c2 = c3 = c4 = Integer.MAX_VALUE;
        if (i - 1 > 0 && mat[i - 1][j] != -1) {
            int num = mat[i - 1][j];
            mat[i - 1][j] = -1;
            c1 = h(mat);
            mat[i - 1][j] = num;
        }
        if (i + 1 > 0 && mat[i + 1][j] != -1) {
            int num = mat[i + 1][j];
            mat[i + 1][j] = -1;
            c2 = h(mat);
            mat[i + 1][j] = num;
        }
        if (j - 1 > 0 && mat[i][j - 1] != -1) {
            int num = mat[i][j - 1];
            mat[i][j - 1] = -1;
            c3 = h(mat);
            mat[i][j - 1] = num;
        }
        if (j + 1 > 0 && mat[i][j + 1] != -1) {
            int num = mat[i][j + 1];
            mat[i][j + 1] = -1;
            c4 = h(mat);
            mat[i][j + 1] = num;
        }
        c = Math.min(Math.min(c1, c2), Math.min(c3, c4));
        findMinMatrix(c, c1, c2, c3, c4, mat, i, j);
        display(mat);
    }

    public static void swap() {

    }

    public static void findMinMatrix(int c, int c1, int c2, int c3, int c4, int[][] mat, int i, int j) {
        if (c1 == c) {
            mat[i - 1][j] = -1;
        } else if (c2 == c) {
            mat[i + 1][j] = -1;
        } else if (c3 == c) {
            mat[i][j - 1] = -1;
        } else if (c4 == c) {
            mat[i][j + 1] = -1;
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
        bb(mat, temp, ans, arr[0], arr[1], h(mat));
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
