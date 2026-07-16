class Solution {
    int[][] dp;

    public int countWays(int n, int sum) {
        if (sum > 9 * n) return -1;

        dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        int ans = solve(0, sum, n);

        return ans == 0 ? -1 : ans;
    }

    private int solve(int pos, int rem, int n) {
        if (pos == n) {
            return rem == 0 ? 1 : 0;
        }

        if (dp[pos][rem] != -1) return dp[pos][rem];

        int ways = 0;

        int start = (pos == 0) ? 1 : 0;

        for (int digit = start; digit <= 9; digit++) {
            if (digit <= rem) {
                ways += solve(pos + 1, rem - digit, n);
            }
        }

        return dp[pos][rem] = ways;
    }
}