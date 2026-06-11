class Solution {
    public int findIndex(String s) {
        int n = s.length();

        int closeRight = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                closeRight++;
            }
        }

        int openLeft = 0;

        for (int i = 0; i < n; i++) {
            if (openLeft == closeRight) {
                return i;
            }

            if (s.charAt(i) == '(') {
                openLeft++;
            } else {
                closeRight--;
            }
        }

        return openLeft == closeRight ? n : -1;
    }
}