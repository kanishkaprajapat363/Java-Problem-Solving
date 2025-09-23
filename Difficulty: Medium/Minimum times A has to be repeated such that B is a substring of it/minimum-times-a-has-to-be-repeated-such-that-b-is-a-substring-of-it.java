class Solution {
    static int minRepeats(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int count = 1;

        // A quick initial check if B is already a substring of A.
        if (A.contains(B)) {
            return count;
        }

        // The maximum length we need to check is A.length() + B.length().
        // If B is a substring, its first character could align with the last character of A
        // requiring one more full A string to complete the match.
        while (sb.length() < A.length() + B.length()) {
            sb.append(A);
            count++;
            if (sb.toString().contains(B)) {
                return count;
            }
        }
        
        return -1;
    }
}