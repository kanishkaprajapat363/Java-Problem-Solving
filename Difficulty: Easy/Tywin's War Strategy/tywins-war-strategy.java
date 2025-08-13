import java.util.*;

class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int target = (n + 1) / 2; // ceil(n / 2)
        
        int luckyCount = 0;
        List<Integer> needs = new ArrayList<>();
        
        for (int num : arr) {
            if (num % k == 0) {
                luckyCount++;
            } else {
                needs.add(k - (num % k));
            }
        }
        
        if (luckyCount >= target) {
            return 0;
        }
        
        Collections.sort(needs);
        int soldiersAdded = 0;
        int i = 0;
        
        while (luckyCount < target && i < needs.size()) {
            soldiersAdded += needs.get(i);
            luckyCount++;
            i++;
        }
        
        return soldiersAdded;
    }
}
