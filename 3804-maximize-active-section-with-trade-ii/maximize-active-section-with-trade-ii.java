import java.util.*;

class Solution {
    static class Group {
        int start;
        int length;

        Group(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    static class SparseTable {
        private final int[][] st;

        public SparseTable(int[] nums) {
            int n = nums.length;
            int maxLog = n == 0 ? 1 : 32 - Integer.numberOfLeadingZeros(n);
            st = new int[maxLog + 1][n + 1];

            for (int i = 0; i < n; i++) {
                st[0][i] = nums[i];
            }

            for (int i = 1; (1 << i) <= n; i++) {
                for (int j = 0; j + (1 << i) <= n; j++) {
                    st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
                }
            }
        }

        public int query(int l, int r) {
            if (l > r) return 0;
            int len = r - l + 1;
            int k = 31 - Integer.numberOfLeadingZeros(len);
            return Math.max(st[k][l], st[k][r - (1 << k) + 1]);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') ones++;
        }

        List<Group> zeroGroups = new ArrayList<>();
        int[] zeroGroupIndex = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    zeroGroups.get(zeroGroups.size() - 1).length++;
                } else {
                    zeroGroups.add(new Group(i, 1));
                }
            }
            zeroGroupIndex[i] = zeroGroups.size() - 1;
        }

        int m = zeroGroups.size();
        int[] zeroMergeLengths = new int[Math.max(0, m - 1)];
        for (int i = 0; i < m - 1; i++) {
            zeroMergeLengths[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;
        }

        SparseTable st = new SparseTable(zeroMergeLengths);
        List<Integer> ans = new ArrayList<>(queries.length);

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            int left = zeroGroupIndex[l] == -1 ? -1 : (zeroGroups.get(zeroGroupIndex[l]).length - (l - zeroGroups.get(zeroGroupIndex[l]).start));
            int right = zeroGroupIndex[r] == -1 ? -1 : (r - zeroGroups.get(zeroGroupIndex[r]).start + 1);

            int startAdjacentGroupIndex = zeroGroupIndex[l] + 1;
            int endGroupIndex = (s.charAt(r) == '1') ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1;
            int endAdjacentGroupIndex = endGroupIndex - 1;

            int activeSections = ones;

            // Case 1: Query contains both truncated ends belonging to adjacent zero groups
            if (s.charAt(l) == '0' && s.charAt(r) == '0' && zeroGroupIndex[l] + 1 == zeroGroupIndex[r]) {
                activeSections = Math.max(activeSections, ones + left + right);
            } 
            // Case 2: Fully internal adjacent zero groups
            else if (startAdjacentGroupIndex <= endAdjacentGroupIndex) {
                activeSections = Math.max(activeSections, ones + st.query(startAdjacentGroupIndex, endAdjacentGroupIndex));
            }

            // Case 3: Truncated left zero group + full adjacent zero group
            if (s.charAt(l) == '0' && zeroGroupIndex[l] + 1 <= (s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1)) {
                activeSections = Math.max(activeSections, ones + left + zeroGroups.get(zeroGroupIndex[l] + 1).length);
            }

            // Case 4: Truncated right zero group + full adjacent zero group
            if (s.charAt(r) == '0' && zeroGroupIndex[l] < zeroGroupIndex[r] - 1) {
                activeSections = Math.max(activeSections, ones + right + zeroGroups.get(zeroGroupIndex[r] - 1).length);
            }

            ans.add(activeSections);
        }

        return ans;
    }
}