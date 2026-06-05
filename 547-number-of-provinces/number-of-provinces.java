class Solution {

    public void dfs(int[][] grid, int city) {

        grid[city][city] = 0; // mark visited

        for (int neighbor = 0; neighbor < grid.length; neighbor++) {

            if (grid[city][neighbor] == 1) {

                grid[city][neighbor] = 0;
                grid[neighbor][city] = 0;

                dfs(grid, neighbor);
            }
        }
    }

    public int findCircleNum(int[][] grid) {

        int n = grid.length;
        int count = 0;

        for (int city = 0; city < n; city++) {

            if (grid[city][city] == 1) {

                count++;

                dfs(grid, city);
            }
        }

        return count;
    }
}