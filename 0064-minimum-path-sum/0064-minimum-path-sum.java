class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        return memo(grid, 0, 0, dp);
    }

    public int memo(int[][] grid, int i, int j, int[][] dp){

        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(i == m - 1 && j == n - 1){
            return grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = memo(grid, i, j + 1, dp);
        int down = memo(grid, i + 1, j, dp);

        dp[i][j] = grid[i][j] + Math.min(right, down);

        return dp[i][j];
    }
}