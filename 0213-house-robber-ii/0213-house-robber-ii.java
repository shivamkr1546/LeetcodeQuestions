class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        // Rob from 0 to n-2 (exclude last)
        int rob1 = robLinear(nums, 0, n - 2);
        // Rob from 1 to n-1 (exclude first)
        int rob2 = robLinear(nums, 1, n - 1);

        return Math.max(rob1, rob2);
    }

    private int robLinear(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[dp.length - 1];
    }
}
