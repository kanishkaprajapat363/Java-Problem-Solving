class Solution {
    public int maxCharGap(String s) {
        int n = s.length();
        
        int[] first = new int[26];
        int[] last = new int[26];
        
        // initialize
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }
        
        // fill first and last occurrences
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }
        
        int maxGap = -1;
        
        // compute max gap
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && first[i] != last[i]) {
                int gap = last[i] - first[i] - 1;
                maxGap = Math.max(maxGap, gap);
            }
        }
        
        return maxGap;
    }
}