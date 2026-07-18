class Solution {
    static final int MOD = 1000000007;

    public int findWays(int[][] matrix, int k) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] apple = new int[n + 1][m + 1];

        // Suffix sum of 1's
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                apple[i][j] = matrix[i][j]
                        + apple[i + 1][j]
                        + apple[i][j + 1]
                        - apple[i + 1][j + 1];
            }
        }

        if (apple[0][0] == 0)
            return 0;

        // First valid horizontal cut
        int[][] downStart = new int[n][m];
        for (int j = 0; j < m; j++) {
            int p = n;
            for (int i = n - 2; i >= 0; i--) {
                if (apple[i][j] > apple[i + 1][j])
                    p = i + 1;
                downStart[i][j] = p;
            }
            if (n > 0)
                downStart[n - 1][j] = n;
        }

        // First valid vertical cut
        int[][] rightStart = new int[n][m];
        for (int i = 0; i < n; i++) {
            int p = m;
            for (int j = m - 2; j >= 0; j--) {
                if (apple[i][j] > apple[i][j + 1])
                    p = j + 1;
                rightStart[i][j] = p;
            }
            if (m > 0)
                rightStart[i][m - 1] = m;
        }

        int[][] dp = new int[n][m];

        // Base case
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = apple[i][j] > 0 ? 1 : 0;

        for (int piece = 2; piece <= k; piece++) {

            int[][] down = new int[n + 1][m];
            int[][] right = new int[n][m + 1];

            // down cumulative
            for (int j = 0; j < m; j++) {
                for (int i = n - 1; i >= 0; i--) {
                    down[i][j] = dp[i][j];
                    if (i + 1 < n) {
                        down[i][j] += down[i + 1][j];
                        if (down[i][j] >= MOD)
                            down[i][j] -= MOD;
                    }
                }
            }

            // right cumulative
            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    right[i][j] = dp[i][j];
                    if (j + 1 < m) {
                        right[i][j] += right[i][j + 1];
                        if (right[i][j] >= MOD)
                            right[i][j] -= MOD;
                    }
                }
            }

            int[][] next = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    long ans = 0;

                    if (downStart[i][j] < n)
                        ans += down[downStart[i][j]][j];

                    if (rightStart[i][j] < m)
                        ans += right[i][rightStart[i][j]];

                    next[i][j] = (int) (ans % MOD);
                }
            }

            dp = next;
        }

        return dp[0][0];
    }
}