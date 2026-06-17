class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len[i + 1] = len[i] + 1;
            } 
            else if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } 
            else if (ch == '#') {
                len[i + 1] = len[i] * 2;
            } 
            else { // '%'
                len[i + 1] = len[i];
            }
        }

        if (k >= len[n]) {
            return '.';
        }

        long idx = k;

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            long prevLen = len[i];
            long currLen = len[i + 1];

            if (ch >= 'a' && ch <= 'z') {

                if (idx == prevLen) {
                    return ch;
                }

            } 
            else if (ch == '#') {

                if (prevLen > 0) {
                    idx %= prevLen;
                }

            } 
            else if (ch == '%') {

                idx = currLen - 1 - idx;

            } 
            else { // '*'
                // index remains unchanged
            }
        }

        return '.';
    }
}