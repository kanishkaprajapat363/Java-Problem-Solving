class Solution {
    int maxSubarraySum(int[] arr) {
        // Initialize
        int ms = arr[0];  // max sum so far
        int cs = arr[0];  // current sum
        
        // Traverse the array
        for (int i = 1; i < arr.length; i++) {
            cs = Math.max(arr[i], cs + arr[i]);  // either extend or start new
            ms = Math.max(ms, cs);               // update global max
        }
        
        return ms;
    }
}
