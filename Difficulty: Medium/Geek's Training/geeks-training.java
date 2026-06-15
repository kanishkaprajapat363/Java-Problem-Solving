
class Solution {

    int solve(int day, int last, int[][] mat, int[][] dp) {

        if (day == 0) {
            int maxi = 0;

            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, mat[0][task]);
                }
            }
            return maxi;
        }

        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int maxi = 0;

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int points = mat[day][task]
                        + solve(day - 1, task, mat, dp);

                maxi = Math.max(maxi, points);
            }
        }

        return dp[day][last] = maxi;
    }

    public int maximumPoints(int[][] mat) {

        int n = mat.length;

        int[][] dp = new int[n][4];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, 3, mat, dp);
    }
}