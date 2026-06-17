class Solution {

    int solve(int i, int j, int[][] mat, int[][] dp) {
        //MEMOIZATION
        int m = mat[0].length;

        if (j < 0 || j >= m)
            return (int)-1e9;

        if (i == 0)
            return mat[0][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = solve(i - 1, j, mat, dp);

        int leftDiag = solve(i - 1, j - 1, mat, dp);

        int rightDiag = solve(i - 1, j + 1, mat, dp);

        return dp[i][j] =
                mat[i][j] +
                Math.max(up,
                Math.max(leftDiag, rightDiag));
    }

    public int maximumPath(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);

        int ans = 0;

        for (int j = 0; j < m; j++) {
            ans = Math.max(ans,
                    solve(n - 1, j, mat, dp));
        }

        return ans;
    }
}