import java.util.*;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;
        
        // If start or end is blocked, no path exists
        if (maze[0][0] == 0 || maze[n-1][n-1] == 0) return result;
        
        boolean[][] visited = new boolean[n][n];
        backtrack(0, 0, maze, visited, "", result, n);
        
        return result;
    }
    
    private void backtrack(int i, int j, int[][] maze, boolean[][] visited, 
                           String path, ArrayList<String> result, int n) {
        // If destination is reached
        if (i == n-1 && j == n-1) {
            result.add(path);
            return;
        }
        
        // Mark current cell visited
        visited[i][j] = true;
        
        // Directions in lexicographical order: D, L, R, U
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};
        
        for (int k = 0; k < 4; k++) {
            int newi = i + di[k];
            int newj = j + dj[k];
            
            if (isSafe(newi, newj, maze, visited, n)) {
                backtrack(newi, newj, maze, visited, path + dir[k], result, n);
            }
        }
        
        // Backtrack: unmark visited
        visited[i][j] = false;
    }
    
    private boolean isSafe(int i, int j, int[][] maze, boolean[][] visited, int n) {
        return (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && !visited[i][j]);
    }
}
