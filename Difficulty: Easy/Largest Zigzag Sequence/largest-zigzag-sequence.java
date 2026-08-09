class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        // dp[i][j] = maximum zigzag sum starting
        // from mat[i][j] and going to the last row
        int[][] dp = new int[n][n];

        // Base case: last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = mat[n - 1][j];
        }

        // Build DP from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                int best = 0;

                // Next element must be from a different column
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        best = Math.max(best, dp[i + 1][k]);
                    }
                }

                dp[i][j] = mat[i][j] + best;
            }
        }

        // We can start from any column in the first row
        int ans = 0;

        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[0][j]);
        }

        return ans;
    }
}