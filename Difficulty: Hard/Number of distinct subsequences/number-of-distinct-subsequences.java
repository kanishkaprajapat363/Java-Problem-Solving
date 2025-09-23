import java.util.Arrays;

class Solution {
    public int distinctSubsequences(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        long MOD = 1000000007;

        // dp[i] will store the number of distinct subsequences of the prefix of length i
        dp[0] = 1; // Represents the empty subsequence

        // To store the last seen index of each character
        int[] last = new int[256];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            char currentChar = s.charAt(i - 1);
            
            // The number of subsequences is twice the number of previous subsequences
            // (either we include the current character or not)
            dp[i] = (2 * dp[i - 1]) % MOD;

            // If the current character has appeared before, we need to subtract
            // the count of subsequences formed with its previous occurrence
            // to avoid duplicates.
            if (last[currentChar] != -1) {
                dp[i] = (dp[i] - dp[last[currentChar] - 1] + MOD) % MOD;
            }

            // Update the last seen index of the current character
            last[currentChar] = i;
        }

        return (int) dp[n];
    }
}