class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // Update leftMax
                } else {
                    trappedWater += leftMax - height[left];  // Add trapped water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // Update rightMax
                } else {
                    trappedWater += rightMax - height[right];  // Add trapped water
                }
                right--;
            }
        }

        return trappedWater;
    }
}
