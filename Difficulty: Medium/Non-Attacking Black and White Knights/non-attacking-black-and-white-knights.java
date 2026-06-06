class Solution {
    public int numOfWays(int n, int m) {

        long cells = 1L * n * m;

        long totalWays = cells * (cells - 1);

        long attackingWays =
                4L * ((long)(n - 1) * (m - 2)
                    + (long)(n - 2) * (m - 1));

        long ans = totalWays - attackingWays;

        return (int) ans;
    }
}