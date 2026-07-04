class Solution {
    
    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int countSubstring(String s) {
        int n = s.length();

        Fenwick ft = new Fenwick(2 * n + 5);

        int offset = n + 2;
        int prefix = 0;

        // Initial prefix sum = 0
        ft.update(offset, 1);

        long ans = 0;

        for (char c : s.toCharArray()) {
            if (c == '1')
                prefix++;
            else
                prefix--;

            int idx = prefix + offset;

            // Count previous prefix sums smaller than current
            ans += ft.query(idx - 1);

            ft.update(idx, 1);
        }

        return (int) ans;
    }
}