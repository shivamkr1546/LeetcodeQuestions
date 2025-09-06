class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
        return memo(coins, amount, n, dp);
    }

    public int memo(int[] coins, int sum, int n, int[][] dp){
        if(n==0) return 0;
        if(sum==0) return 1;

        if(dp[n][sum] != -1) return dp[n][sum];

        if(coins[n-1] <= sum){
            return dp[n][sum] = memo(coins, sum-coins[n-1], n, dp) + memo(coins, sum, n-1, dp);
        }else{
            return dp[n][sum] = memo(coins, sum, n-1, dp);
        }
    }
}