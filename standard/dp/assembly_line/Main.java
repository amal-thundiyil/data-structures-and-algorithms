import java.util.*;
import java.lang.Math;

public class Main {
    static void solve(Scanner in) {
        int n = in.nextInt();
        int cost_a[] = new int[n + 1];
        int cost_b[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cost_a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cost_b[i] = in.nextInt();
        }
        int cost_a_b[] = new int[n];
        int cost_b_a[] = new int[n];
        for (int i = 1; i < n; i++)
            cost_a_b[i] = in.nextInt();
        for (int i = 1; i < n; i++)
            cost_b_a[i] = in.nextInt();

        int arr_1[] = new int[n + 1];
        int arr_2[] = new int[n + 1];
        Arrays.fill(arr_1, 0);
        Arrays.fill(arr_2, 0);
        int path[][] = new int[2][n + 2];
        for (int i = 1; i <= n; i++) {
            arr_1[i] = Math.min(arr_1[i - 1], arr_2[i - 1] + cost_b_a[i - 1]) +
                    cost_a[i - 1];
            if (Math.min(arr_1[i - 1], arr_2[i - 1] + cost_b_a[i - 1]) == arr_1[i - 1]) {
                path[0][i] = 1;
            } else {
                path[0][i] = 2;
            }
            arr_2[i] = Math.min(arr_2[i - 1], arr_1[i - 1] + cost_a_b[i - 1]) + cost_b[i - 1];
            if (Math.min(arr_2[i - 1], arr_1[i - 1] + cost_a_b[i - 1]) == arr_2[i - 1]) {
                path[1][i] = 2;
            } else {
                path[1][i] = 1;
            }
        }
        if (Math.min(arr_1[n], arr_2[n]) == arr_1[n]) {
            path[0][n + 1] = 1;
            path[1][n + 1] = 1;
        } else {
            path[0][n + 1] = 2;
            path[1][n + 1] = 2;
        }
        System.out.println("\nPath: ");
        for (int i = 0; i <= 1; i++)
            System.err.println(Arrays.toString(path[i]));
        System.err.println();
        System.out.println(Math.min(arr_1[n], arr_2[n]));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0)
            solve(in);
        in.close();
    }
}