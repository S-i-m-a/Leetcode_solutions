class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, h * width);

            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
