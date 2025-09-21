class Solution {
    static int maxArea(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int maxArea = 0;

        int[] height = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                height[j] = (mat[i][j] == 0) ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }

    static int largestRectangleArea(int[] heights) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
