import java.util.Arrays;

class Solution {
    public int maxMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr[arr.length - 1] - arr[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(arr, k, mid)) {
                result = mid;      // possible, try for a bigger minimum difference
                low = mid + 1;
            } else {
                high = mid - 1;    // not possible, try smaller
            }
        }

        return result;
    }

    private boolean canPlace(int[] arr, int k, int minDiff) {
        int count = 1; // first element is always chosen
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= minDiff) {
                count++;
                last = arr[i];
            }
            if (count == k) return true;
        }

        return false;
    }
}
