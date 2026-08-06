class Solution {
    public int countMinOperations(int arr[]) {
        int ans = 0;

        while (true) {

            // Remove all odd values
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & 1) == 1) {
                    arr[i]--;
                    ans++;
                }
            }

            // Check if all elements are zero
            boolean allZero = true;
            for (int num : arr) {
                if (num != 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero)
                return ans;

            // Divide all elements by 2
            for (int i = 0; i < arr.length; i++) {
                arr[i] /= 2;
            }

            ans++;
        }
    }
}