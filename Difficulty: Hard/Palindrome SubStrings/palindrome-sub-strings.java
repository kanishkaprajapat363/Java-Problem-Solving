class Solution {
    public int countPS(String s) {
        int n = s.length();
        int count = 0;

        // Check for odd length palindromes (center at a single character)
        for (int center = 0; center < n; center++) {
            count += expandAroundCenter(s, center, center);
        }

        // Check for even length palindromes (center between two characters)
        for (int center = 0; center < n - 1; center++) {
            count += expandAroundCenter(s, center, center + 1);
        }

        return count;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // Consider only substrings length >= 2
            if (right - left + 1 >= 2) {
                count++;
            }
            left--;
            right++;
        }

        return count;
    }
}
