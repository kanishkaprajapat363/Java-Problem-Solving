class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;

        boolean[][] vis = new boolean[n][m];

        return dfs(mat, xs, ys, xd, yd, vis);
    }

    private int dfs(int[][] mat, int r, int c, int xd, int yd, boolean[][] vis) {

        if (r == xd && c == yd)
            return 0;

        vis[r][c] = true;

        int ans = -1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(mat, nr, nc, vis)) {
                int dist = dfs(mat, nr, nc, xd, yd, vis);

                if (dist != -1)
                    ans = Math.max(ans, dist + 1);
            }
        }

        vis[r][c] = false; // Backtrack

        return ans;
    }

    private boolean isValid(int[][] mat, int r, int c, boolean[][] vis) {

        return r >= 0 && c >= 0 &&
               r < mat.length &&
               c < mat[0].length &&
               mat[r][c] == 1 &&
               !vis[r][c];
    }
}