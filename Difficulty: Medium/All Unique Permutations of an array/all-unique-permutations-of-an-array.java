import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        Arrays.sort(arr);  // Step 1: sort array
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), used, result);
        return result;
    }

    private static void backtrack(int[] arr, ArrayList<Integer> temp, boolean[] used,
                                  ArrayList<ArrayList<Integer>> result) {
        if (temp.size() == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // Skip already used elements
            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(arr[i]);

            backtrack(arr, temp, used, result);

            // backtrack
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
