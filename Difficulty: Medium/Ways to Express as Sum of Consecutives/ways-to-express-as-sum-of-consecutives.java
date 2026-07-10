class Solution {
    public int getCount(int n) {
        int oddDivisors = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if ((i & 1) == 1) oddDivisors++;

                int other = n / i;
                if (other != i && (other & 1) == 1) oddDivisors++;
            }
        }

        return oddDivisors - 1;
    }
}