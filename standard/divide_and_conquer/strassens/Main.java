import java.io.PrintWriter;

public class Main {

    public int[][] multiply(int A[][], int B[][]) {
        int n = A.length;
        int[][] ans = new int[A.length][A.length];
        if (n == 1) {
            ans[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);

            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);

            // M1 = (A11 + A22) x (B11 + B12)
            // M2 = (A12 + A21) x B11
            // M3 = A11 x (B12 - B22)
            // M4 = A22 x (B21 - B11)
            // M5 = (A11 + A12) x B22
            // M6 = (A21 - A11) x (B11 + B12)
            // M7 = (A12 - A22) x (B12 + B21)

            int[][] P = multiply(add(A11, A22), add(B11, B12));
            int[][] Q = multiply(add(A12, A21), B11);
            int[][] R = multiply(A11, sub(B12, B22));
            int[][] S = multiply(A22, sub(B21, B11));
            int[][] T = multiply(add(A11, A12), B22);
            int[][] U = multiply(sub(A21, A11), add(B11, B12));
            int[][] V = multiply(sub(A12, A22), add(B12, B21));

            int[][] C1 = add(sub(add(P, S), T), V);
            int[][] C2 = add(R, T);
            int[][] C3 = add(Q, S);
            int[][] C4 = add(sub(add(P, S), Q), U);

            join(C1, ans, 0, 0);
            join(C2, ans, 0, n / 2);
            join(C3, ans, n / 2, 0);
            join(C4, ans, n / 2, n / 2);
        }
        return ans;
    }

    public int[][] add(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public int[][] sub(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public void split(int[][] P, int[][] C, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
                C[i1][j1] = P[i2][j2];
            }
        }
    }

    public void join(int[][] C, int[][] P, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
                P[i2][j2] = C[i1][j1];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        strassen s = new strassen();
        int N = 4;
        int[][] A = { { 1, 2, 5, 4 },
                { 9, 3, 0, 6 },
                { 4, 6, 3, 1 },
                { 0, 2, 0, 6 } };

        int[][] B = { { 1, 0, 4, 1 },
                { 1, 2, 0, 2 },
                { 0, 3, 1, 3 },
                { 1, 8, 1, 2 } };

        int[][] C = s.multiply(A, B);

        // pw.println("\nProduct of matrices A and  B : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        pw.close();
    }

}

