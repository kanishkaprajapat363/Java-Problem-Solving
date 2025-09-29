

class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        long ans = Long.MIN_VALUE;

        for (int i = a; i <= n; i++) {
            // add prefix[i - a] to deque (new eligible start)
            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[i - a]) {
                dq.pollLast();
            }
            dq.addLast(i - a);

            // remove out-of-range indices
            while (!dq.isEmpty() && dq.peekFirst() < i - b) {
                dq.pollFirst();
            }

            // calculate max sum
            ans = Math.max(ans, prefix[i] - prefix[dq.peekFirst()]);
        }

        return (int) ans;
    }
}
