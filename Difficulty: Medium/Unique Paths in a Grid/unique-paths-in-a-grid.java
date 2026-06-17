class Solution {

    int solve(int i, int j, int[][] grid, int[][] dp) {

        // Out of bounds
        if (i < 0 || j < 0)
            return 0;

        // Blocked cell
        if (grid[i][j] == 1)
            return 0;

        // Reached source
        if (i == 0 && j == 0)
            return 1;

        // Already computed
        if (dp[i][j] != -1)
            return dp[i][j];

        int up = solve(i - 1, j, grid, dp);
        int left = solve(i, j - 1, grid, dp);

        return dp[i][j] = up + left;
    }

    public int uniquePaths(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return 0;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, m - 1, grid, dp);
    }
}