class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the full number (could be >9)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current number and string
                countStack.push(k);
                stringStack.push(curr);
                // Reset
                k = 0;
                curr = new StringBuilder();
            } else if (ch == ']') {
                // Pop count and previous string
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();
                // Append repeated substring
                for (int i = 0; i < repeat; i++) {
                    prev.append(curr);
                }
                curr = prev;
            } else {
                // Just a character
                curr.append(ch);
            }
        }
        
        return curr.toString();
    }
}
