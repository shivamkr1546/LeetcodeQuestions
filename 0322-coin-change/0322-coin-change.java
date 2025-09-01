class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
        int ans = memo(coins, amount, n, dp);
        return (ans == Integer.MAX_VALUE - 1 ? -1 : ans);
    }

    int memo(int[] coins, int sum, int n, int[][] dp){
        if(sum == 0) return 0;
        if(n==0) return Integer.MAX_VALUE - 1;

        if(dp[n][sum] != -1) return dp[n][sum];

        if(coins[n-1] <= sum){
            return dp[n][sum] = Math.min(memo(coins, sum, n-1, dp), 1 + memo(coins, sum-coins[n-1], n, dp));
        }else{
            return dp[n][sum] = memo(coins, sum, n-1, dp);
        }
    }
}