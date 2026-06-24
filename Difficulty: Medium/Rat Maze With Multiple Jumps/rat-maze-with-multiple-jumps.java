import java.util.*;

class Solution {

    int n;
    int[][] mat;
    int[][] path;
    boolean[][] failed;

    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {

        this.mat = mat;
        n = mat.length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (mat[0][0] == 0) {
            ans.add(new ArrayList<>(Arrays.asList(-1)));
            return ans;
        }

        path = new int[n][n];
        failed = new boolean[n][n];

        if (!dfs(0, 0)) {
            ans.add(new ArrayList<>(Arrays.asList(-1)));
            return ans;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(path[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }

    private boolean dfs(int r, int c) {

        if (r == n - 1 && c == n - 1) {
            path[r][c] = 1;
            return true;
        }

        if (failed[r][c]) return false;

        path[r][c] = 1;

        int jump = mat[r][c];

        for (int step = 1; step <= jump; step++) {

            // Right first (required by statement)
            int nc = c + step;
            if (nc < n && mat[r][nc] != 0) {
                if (dfs(r, nc))
                    return true;
            }

            // Then Down
            int nr = r + step;
            if (nr < n && mat[nr][c] != 0) {
                if (dfs(nr, c))
                    return true;
            }
        }

        path[r][c] = 0;
        failed[r][c] = true; // memoize impossible state

        return false;
    }
}