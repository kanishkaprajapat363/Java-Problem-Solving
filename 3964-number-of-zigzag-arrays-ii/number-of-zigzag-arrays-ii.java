class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        int size = 2 * m;

        // Vector for length = 2
        long[] vec = new long[size];

        for (int i = 0; i < m; i++) {
            vec[i] = i;               // up[i]
            vec[m + i] = m - 1 - i;   // down[i]
        }

        if (n == 2) {
            long ans = 0;
            for (long x : vec) ans = (ans + x) % MOD;
            return (int) ans;
        }

        long[][] mat = new long[size][size];

        // newUp[i] = sum down[j] where j < i
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                mat[i][m + j] = 1;
            }
        }

        // newDown[i] = sum up[j] where j > i
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                mat[m + i][j] = 1;
            }
        }

        long[][] power = matrixPower(mat, n - 2);

        long[] result = multiply(power, vec);

        long ans = 0;
        for (long x : result) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum = (sum + A[i][j] * v[j]) % MOD;
            }
            res[i] = sum;
        }

        return res;
    }

    private long[][] matrixPower(long[][] base, long exp) {
        int n = base.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long a = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + a * B[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}