import java.util.*;

class Solution {

    static class Pair {
        long count; // number of valid numbers
        long sum;   // total waviness

        Pair(long c, long s) {
            count = c;
            sum = s;
        }
    }

    private char[] digits;
    private Pair[][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        digits = String.valueOf(x).toCharArray();

        memo = new Pair[16][2][11][11];

        return dfs(0, true, false, -1, -1).sum;
    }

    private Pair dfs(int pos,
                     boolean tight,
                     boolean started,
                     int prev2,
                     int prev1) {

        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (!tight) {
            int s = started ? 1 : 0;
            if (memo[pos][s][prev2 + 1][prev1 + 1] != null) {
                return memo[pos][s][prev2 + 1][prev1 + 1];
            }
        }

        int limit = tight ? digits[pos] - '0' : 9;

        long totalCount = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            boolean nextTight = tight && (d == limit);

            if (!started && d == 0) {

                Pair child = dfs(
                        pos + 1,
                        nextTight,
                        false,
                        -1,
                        -1
                );

                totalCount += child.count;
                totalSum += child.sum;

            } else {

                Pair child;

                if (!started) {
                    child = dfs(
                            pos + 1,
                            nextTight,
                            true,
                            -1,
                            d
                    );

                    totalCount += child.count;
                    totalSum += child.sum;
                } else {

                    int add = 0;

                    if (prev2 != -1) {
                        if ((prev1 > prev2 && prev1 > d) ||
                            (prev1 < prev2 && prev1 < d)) {
                            add = 1;
                        }
                    }

                    child = dfs(
                            pos + 1,
                            nextTight,
                            true,
                            prev1,
                            d
                    );

                    totalCount += child.count;

                    totalSum += child.sum + (long) add * child.count;
                }
            }
        }

        Pair ans = new Pair(totalCount, totalSum);

        if (!tight) {
            int s = started ? 1 : 0;
            memo[pos][s][prev2 + 1][prev1 + 1] = ans;
        }

        return ans;
    }
}