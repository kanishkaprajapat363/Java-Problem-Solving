import java.util.*;

class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        // Frequency map of characters in p
        int[] freqP = new int[256];
        for (char c : p.toCharArray()) {
            freqP[c]++;
        }

        int[] freqS = new int[256];
        int start = 0, startIndex = -1, minLen = Integer.MAX_VALUE;
        int count = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freqS[c]++;

            // If character c is needed and we haven’t exceeded required count
            if (freqP[c] != 0 && freqS[c] <= freqP[c]) {
                count++;
            }

            // When all characters of p are included
            if (count == p.length()) {
                // Shrink the window from the left
                while (freqP[s.charAt(start)] == 0 || freqS[s.charAt(start)] > freqP[s.charAt(start)]) {
                    if (freqS[s.charAt(start)] > freqP[s.charAt(start)]) {
                        freqS[s.charAt(start)]--;
                    }
                    start++;
                }

                int windowLen = end - start + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = start;
                }
            }
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice", "toc"));  // Output: "toprac"
        System.out.println(smallestWindow("zoomlazapzo", "oza"));     // Output: "apzo"
        System.out.println(smallestWindow("zoom", "zooe"));           // Output: ""
    }
}
