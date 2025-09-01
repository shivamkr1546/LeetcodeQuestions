class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++) dp[i][0] = 0;
        for(int j=1; j<=m; j++) dp[0][j] = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        int i=n, j=m;

        while (i > 0 && j > 0) {
            if (text1.charAt(i-1) == text2.charAt(j-1)) {
                str.append(text1.charAt(i-1));
                i--; j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                str.append(text1.charAt(i-1));
                i--;
            } else {
                str.append(text2.charAt(j-1));
                j--;
            }
        }

        // Add remaining characters
        while (i > 0) {
            str.append(text1.charAt(i-1));
            i--;
        }
        while (j > 0) {
            str.append(text2.charAt(j-1));
            j--;
        }

        return str.reverse().toString();
    }
}