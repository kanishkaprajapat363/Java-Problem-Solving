class Solution {
    int maxPeopleDefeated(int p) {
        int low = 0, high = 1000;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long sum = 1L * mid * (mid + 1) * (2L * mid + 1) / 6;

            if (sum <= p) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}