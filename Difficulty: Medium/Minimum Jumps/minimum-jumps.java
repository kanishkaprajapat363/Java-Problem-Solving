class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        if (n <= 1) return 0; // already at the end
        if (arr[0] == 0) return -1; // can't move anywhere
        
        int jumps = 1;          // we make the first jump from index 0
        int maxReach = arr[0];  // farthest we can go initially
        int steps = arr[0];     // steps left before we must jump again
        
        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps; // reached the last index
            
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1; // stuck
                steps = maxReach - i;
            }
        }
        
        return -1;
    }
}
