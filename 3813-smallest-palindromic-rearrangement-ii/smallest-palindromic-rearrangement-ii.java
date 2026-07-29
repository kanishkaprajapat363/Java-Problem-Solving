import java.util.*;

class Solution {

    static final int LIMIT = 1_000_000;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        char mid = 0;
        int len = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
        }

        if (countWays(half, len) < k) return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;
                long ways = countWays(half, len - pos - 1);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if (mid != 0) ans.append(mid);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countWays(int[] cnt, int total) {
        long ways = 1;
        int rem = total;

        for (int x : cnt) {
            if (x == 0) continue;
            long choose = combCap(rem, x);

            ways *= choose;
            if (ways > LIMIT) return LIMIT + 1;

            rem -= x;
        }

        return ways;
    }

    private long combCap(int n, int r) {
        r = Math.min(r, n - r);
        long res = 1;

        for (int i = 1; i <= r; i++) {
            long num = n - r + i;
            long den = i;

            long g = gcd(num, den);
            num /= g;
            den /= g;

            g = gcd(res, den);
            res /= g;
            den /= g;

            res *= num;
            if (res > LIMIT) return LIMIT + 1;

            res /= den;
        }

        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}