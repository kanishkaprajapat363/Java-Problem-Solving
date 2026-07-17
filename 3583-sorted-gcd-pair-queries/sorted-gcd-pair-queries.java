class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums)
            freq[x]++;

        long[] cnt = new long[max + 1];

        // numbers divisible by i
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                cnt[i] += freq[j];
            }
        }

        long[] exact = new long[max + 1];

        // inclusion-exclusion
        for (int i = max; i >= 1; i--) {

            exact[i] = cnt[i] * (cnt[i] - 1) / 2;

            for (int j = i + i; j <= max; j += i) {
                exact[i] -= exact[j];
            }
        }

        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++)
            prefix[i] = prefix[i - 1] + exact[i];

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            long k = queries[q] + 1;

            int lo = 1;
            int hi = max;

            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (prefix[mid] >= k)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            ans[q] = lo;
        }

        return ans;
    }
}