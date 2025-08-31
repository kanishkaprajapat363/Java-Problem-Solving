class Solution {
    public int maxWater(int arr[]) {
        int left = 0, right = arr.length - 1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer of the smaller height
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
