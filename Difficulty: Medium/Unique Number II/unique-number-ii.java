import java.util.*;

class Solution {
    public int[] singleNum(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        
        // Get rightmost set bit
        int setBit = xor & -xor;
        
        int x = 0, y = 0;
        for (int num : arr) {
            if ((num & setBit) != 0) {
                x ^= num; // group 1
            } else {
                y ^= num; // group 2
            }
        }
        
        // Sort before returning
        int[] result = new int[]{x, y};
        Arrays.sort(result);
        return result;
    }
}
