import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        // Convert numbers to strings for easy concatenation
        String[] nums = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = String.valueOf(arr[i]);
        }

        // Sort using custom comparator
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Compare by concatenation
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // descending order
            }
        });

        // If largest number is "0", result is just "0"
        if (nums[0].equals("0")) return "0";

        // Build result
        StringBuilder result = new StringBuilder();
        for (String num : nums) {
            result.append(num);
        }

        return result.toString();
    }
}
