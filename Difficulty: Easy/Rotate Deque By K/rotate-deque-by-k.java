import java.util.*;

class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        if (n == 0) return;

        k = k % n; // optimize unnecessary full rotations
        if (k == 0) return;

        if (type == 1) { 
            // Right rotation
            for (int i = 0; i < k; i++) {
                dq.offerFirst(dq.pollLast());
            }
        } else if (type == 2) { 
            // Left rotation
            for (int i = 0; i < k; i++) {
                dq.offerLast(dq.pollFirst());
            }
        }
    }
}
