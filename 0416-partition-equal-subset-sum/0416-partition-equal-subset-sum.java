class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }

        sum = sum / 2;

        Boolean[][] dp = new Boolean[n+1][sum+1];
        
        return memo(nums, sum, n, dp);
    }

    public boolean memo(int[] nums, int sum, int n, Boolean[][] dp){
        if(n==0) return (sum==0);

        if(dp[n][sum] != null) return (boolean)dp[n][sum];

        if(nums[n-1] <= sum){
            dp[n][sum] = memo(nums, sum - nums[n-1], n-1, dp) || memo(nums, sum, n-1, dp);
        }else{
            dp[n][sum] = memo(nums, sum, n-1, dp);
        }

        return (boolean)dp[n][sum];
    }
}