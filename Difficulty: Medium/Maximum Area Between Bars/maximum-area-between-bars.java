class Solution {
    public int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height.get(left), height.get(right));
            int width = right - left - 1; // bars between them

            maxArea = Math.max(maxArea, h * width);

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}