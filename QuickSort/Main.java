package QuickSort;

import java.util.*;
import java.io.*;

public class Main {
    static FastReader fs;
    static PrintWriter pw;

    public void merge(int[] arr, int lo, int hi) {
        int mid = (lo + hi) / 2;
        int[] temp = new int[arr.length];
        int i = lo, j = mid + 1, k = 0;
        while (i <= mid || j <= hi) {
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
        System.arraycopy(temp, lo, arr, hi, hi - lo + 1);

    }

    public void mergeSort(int[] arr, int lo, int hi) {
        int mid = (lo + hi) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, hi);
    }

    public void solve() {
        int n;
        n = fs.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }
        mergeSort(arr, 0, n - 1);
    }

    public void main(String[] args) throws Exception {
        // System.setErr(new PrintStream("error.txt"));
        fs = new FastReader();
        pw = new PrintWriter(System.out);
        int t = 1;
        t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }
}

class FastReader {
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
