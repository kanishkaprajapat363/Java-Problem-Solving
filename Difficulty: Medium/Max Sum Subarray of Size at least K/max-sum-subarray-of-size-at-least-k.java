class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;

        // maxEnd[i] = maximum subarray sum ending at i
        int[] maxEnd = new int[n];
        maxEnd[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEnd[i] = Math.max(arr[i], maxEnd[i - 1] + arr[i]);
        }

        // Sum of first k elements
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int ans = windowSum;

        for (int i = k; i < n; i++) {
            // Slide the window
            windowSum += arr[i] - arr[i - k];

            // Window of exactly k elements
            ans = Math.max(ans, windowSum);

            // Extend the window using previous best subarray
            ans = Math.max(ans, windowSum + maxEnd[i - k]);
        }

        return ans;
    }
}