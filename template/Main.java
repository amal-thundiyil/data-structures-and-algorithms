package template;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class Main {
    static FastReader fs;
    static PrintWriter pw;

    public void solve() {
    }

    public void main(String[] args) throws Exception {
        System.setErr(new PrintStream("error.txt"));
        System.setIn(new FileInputStream("input.txt"));
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



    static FastReader fs;
    static PrintWriter pw;

    public static void solve() {

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