import java.util.*;

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;

        // Arrays to store previous and next smaller elements
        int[] left = new int[n];   // previous smaller index
        int[] right = new int[n];  // next smaller index

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Stack<Integer> st = new Stack<>();

        // Fill left[] (Previous Smaller Element)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) left[i] = st.peek();
            st.push(i);
        }

        st.clear();

        // Fill right[] (Next Smaller Element)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) right[i] = st.peek();
            st.push(i);
        }

        // res[len] stores max of min for window size len
        int[] res = new int[n + 1];

        // Fill res[] using lengths
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1; // window size where arr[i] is min
            res[len] = Math.max(res[len], arr[i]);
        }

        // Fill missing entries
        for (int i = n - 1; i >= 1; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }

        // Convert result to ArrayList
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(res[i]);
        }

        return ans;
    }
}
