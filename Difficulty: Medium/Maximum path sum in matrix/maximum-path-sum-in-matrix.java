class Solution {

    public int maximumPath(int[][] mat) {
        //space optimization
        int n = mat.length;
        int m = mat[0].length;

        int[] prev = new int[m];

        for (int j = 0; j < m; j++) {
            prev[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {

            int[] curr = new int[m];

            for (int j = 0; j < m; j++) {

                int up = prev[j];

                int leftDiag = (j > 0)
                        ? prev[j - 1]
                        : (int)-1e9;

                int rightDiag = (j < m - 1)
                        ? prev[j + 1]
                        : (int)-1e9;

                curr[j] = mat[i][j]
                        + Math.max(up,
                        Math.max(leftDiag, rightDiag));
            }

            prev = curr;
        }

        int ans = 0;

        for (int val : prev) {
            ans = Math.max(ans, val);
        }

        return ans;
    }
}