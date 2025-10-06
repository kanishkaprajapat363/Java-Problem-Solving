import java.util.*;

class Solution {
    int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[][] board = new int[n][n];

        // initialize board with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], -1);
        }

        board[0][0] = 0; // start from (0, 0)

        if (solve(0, 0, 1, board, n)) {
            // convert board[][] to ArrayList<ArrayList<Integer>>
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(board[i][j]);
                }
                result.add(row);
            }
            return result;
        }
        return result; // will be empty if no solution
    }

    private boolean solve(int x, int y, int moveCount, int[][] board, int n) {
        if (moveCount == n * n) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int nextX = x + dx[k];
            int nextY = y + dy[k];

            if (isSafe(nextX, nextY, board, n)) {
                board[nextX][nextY] = moveCount;
                if (solve(nextX, nextY, moveCount + 1, board, n)) {
                    return true;
                }
                board[nextX][nextY] = -1; // backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int x, int y, int[][] board, int n) {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }
}
