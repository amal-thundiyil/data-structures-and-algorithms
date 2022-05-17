import java.util.*;
import java.io.*;

public class Main {
    static Scanner fs;
    static PrintWriter pw;

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] >= pivot) {
                hi--;
            }
            arr[lo] = arr[hi];
            while (lo < hi && arr[lo] <= pivot) {
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[lo] = pivot;
        return lo;
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = partition(arr, lo, hi);
        quickSort(arr, lo, mid);
        quickSort(arr, mid + 1, hi);
    }

    public static void solve() {
        int n;
        n = fs.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }
        quickSort(arr, 0, n - 1);
        pw.println(Arrays.toString(arr));
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
