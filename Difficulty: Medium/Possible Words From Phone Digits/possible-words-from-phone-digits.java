import java.util.*;

class Solution {

    public ArrayList<String> possibleWords(int[] arr) {
        String[] keypad = {
            "",     "",     "abc", "def", 
            "ghi",  "jkl", "mno", 
            "pqrs", "tuv", "wxyz"
        };

        ArrayList<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;

        backtrack(arr, keypad, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int[] arr, String[] keypad, int index, StringBuilder current, ArrayList<String> result) {
        if (index == arr.length) {
            if (current.length() > 0) {  // only add non-empty combinations
                result.add(current.toString());
            }
            return;
        }

        String letters = keypad[arr[index]];
        if (letters.isEmpty()) {
            // Skip digits 0 and 1
            backtrack(arr, keypad, index + 1, current, result);
        } else {
            for (char c : letters.toCharArray()) {
                current.append(c);
                backtrack(arr, keypad, index + 1, current, result);
                current.deleteCharAt(current.length() - 1); // backtrack
            }
        }
    }
}
