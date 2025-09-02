class Solution {
    public int minInsertions(String s) {
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(s).reverse();
        
        int n = s.length();
        int m = s.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(sb1.charAt(i-1) == sb2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return n - dp[n][m];
    }
}