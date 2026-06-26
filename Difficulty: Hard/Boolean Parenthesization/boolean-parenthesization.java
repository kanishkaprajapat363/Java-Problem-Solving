class Solution {
    static int countWays(String s) {
        int n = s.length();

        int[][] t = new int[n][n];
        int[][] f = new int[n][n];

        // Base case
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) == 'T')
                t[i][i] = 1;
            else
                f[i][i] = 1;
        }

        // len = length of substring (always odd)
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i + len - 1 < n; i += 2) {
                int j = i + len - 1;

                for (int k = i + 1; k < j; k += 2) {
                    char op = s.charAt(k);

                    int lt = t[i][k - 1];
                    int lf = f[i][k - 1];
                    int rt = t[k + 1][j];
                    int rf = f[k + 1][j];

                    if (op == '&') {
                        t[i][j] += lt * rt;
                        f[i][j] += lt * rf + lf * rt + lf * rf;
                    } else if (op == '|') {
                        t[i][j] += lt * rt + lt * rf + lf * rt;
                        f[i][j] += lf * rf;
                    } else { // '^'
                        t[i][j] += lt * rf + lf * rt;
                        f[i][j] += lt * rt + lf * rf;
                    }
                }
            }
        }

        return t[0][n - 1];
    }
}