class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int active = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') active++;
        }

        String t = "1" + s + "1";
        int m = t.length();

        // Run-length encoding
        java.util.ArrayList<Character> ch = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> len = new java.util.ArrayList<>();

        int i = 0;
        while (i < m) {
            char c = t.charAt(i);
            int j = i;
            while (j < m && t.charAt(j) == c) j++;
            ch.add(c);
            len.add(j - i);
            i = j;
        }

        int bestGain = 0;

        // Internal 1-runs (0...1...0)
        for (int k = 1; k < ch.size() - 1; k++) {
            if (ch.get(k) == '1'
                    && ch.get(k - 1) == '0'
                    && ch.get(k + 1) == '0') {

                int gain = len.get(k - 1) + len.get(k + 1);
                bestGain = Math.max(bestGain, gain);
            }
        }

        return Math.min(n, active + bestGain);
    }
}