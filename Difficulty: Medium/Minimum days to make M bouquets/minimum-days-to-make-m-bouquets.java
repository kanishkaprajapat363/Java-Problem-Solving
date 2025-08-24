class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        
        // Impossible if not enough flowers
        if ((long) m * k > n) return -1;

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int val : arr) {
            left = Math.min(left, val);
            right = Math.max(right, val);
        }

        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMake(arr, k, m, mid)) {
                ans = mid;
                right = mid - 1; // try earlier day
            } else {
                left = mid + 1; // need more days
            }
        }
        return ans;
    }

    private boolean canMake(int[] arr, int k, int m, int day) {
        int count = 0;   // consecutive bloomed flowers
        int bouquets = 0;
        
        for (int val : arr) {
            if (val <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                    if (bouquets >= m) return true;
                }
            } else {
                count = 0; // reset if flower not bloomed
            }
        }
        return bouquets >= m;
    }
}
