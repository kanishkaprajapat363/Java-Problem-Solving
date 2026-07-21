class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] best = new int[26];
        
        for (int i = 0; i < 26; i++) {
            best[i] = -1;
        }

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';
            int end = i;

            if (ch < 25 && best[ch + 1] != -1) {
                end = best[ch + 1];
            }

            if (end > best[ch]) {
                best[ch] = end;
            }

            if (ch == 0) {
                ans = Math.max(ans, end - i);
            }
        }

        return ans;
    }
}