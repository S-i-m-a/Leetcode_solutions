public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            // compute area with current pair
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;
            if (area > max) {
                max = area;
            }

            // move the pointer at the shorter line inward,
            // because that line is the limiting factor
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
