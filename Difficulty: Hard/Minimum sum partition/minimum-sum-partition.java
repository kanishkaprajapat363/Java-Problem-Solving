class Solution {

    public int minDifference(int arr[]) {

        int total = 0;
        for (int x : arr)
            total += x;

        boolean[] dp = new boolean[total + 1];
        dp[0] = true;

        for (int num : arr) {

            for (int target = total; target >= num; target--) {

                dp[target] = dp[target] || dp[target - num];
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int s1 = 0; s1 <= total / 2; s1++) {

            if (dp[s1]) {

                int diff = total - 2 * s1;
                ans = Math.min(ans, diff);
            }
        }

        return ans;
    }
}