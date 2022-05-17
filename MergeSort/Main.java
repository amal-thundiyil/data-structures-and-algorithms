import java.util.*;
import java.io.*;

public class Main {
    static Scanner fs;
    static PrintWriter pw;

    public static void merge(int[] arr, int lo, int hi) {
        int mid = (lo + hi) / 2;
        int[] temp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;
        while (i <= mid && j <= hi) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= hi) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, lo, hi - lo + 1);
    }

    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, hi);
    }

    public static void solve() {
        int n;
        n = fs.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        pw.println(Arrays.toString(arr));
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