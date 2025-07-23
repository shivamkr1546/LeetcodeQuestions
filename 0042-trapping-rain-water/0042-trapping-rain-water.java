class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedRainwater = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // update leftMax
                } else {
                    trappedRainwater += leftMax - height[left];  // trap water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // update rightMax
                } else {
                    trappedRainwater += rightMax - height[right];  // trap water
                }
                right--;
            }
        }

        return trappedRainwater;
    }
}
