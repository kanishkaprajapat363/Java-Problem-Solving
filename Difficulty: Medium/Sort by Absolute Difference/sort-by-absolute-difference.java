import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {
        // Pair elements with their absolute difference
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            return Integer.compare(diffA, diffB); // stable sort keeps order if equal
        });

        // Copy back into arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
