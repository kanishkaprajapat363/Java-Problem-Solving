import java.util.ArrayList;

class Solution {
    int shortestDistance(ArrayList<String> s, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < s.size(); i++) {
            String currentWord = s.get(i);
            
            if (currentWord.equals(word1)) {
                index1 = i;
            }
            
            if (currentWord.equals(word2)) {
                index2 = i;
            }

            // Once both words are found, we can start calculating the distance.
            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }
        
        return minDistance;
    }
}