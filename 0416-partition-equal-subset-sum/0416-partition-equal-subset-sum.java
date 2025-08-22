class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) return false;
        sum = sum / 2;

        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        return memo(nums, n, sum, dp);
    }

    public boolean memo(int[] nums, int n, int sum, Boolean[][] dp) {
        if (sum == 0) return true;   // ✅ base case 1: sum achieved
        if (n == 0) return false;    // ✅ base case 2: no numbers left

        if (dp[n][sum] != null) return dp[n][sum];

        if (nums[n - 1] <= sum) {
            // include OR exclude
            return dp[n][sum] = memo(nums, n - 1, sum - nums[n - 1], dp) 
                              || memo(nums, n - 1, sum, dp);
        } else {
            // only exclude
            return dp[n][sum] = memo(nums, n - 1, sum, dp);
        }
    }
}
