class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            if(!vis[i][0] && grid[i][0] == 1){
                dfs(i, 0, vis, grid, n, m);
            }
            if(!vis[i][m-1] && grid[i][m-1] == 1){
                dfs(i, m-1, vis, grid, n, m);
            }
        }

        for(int i=0; i<m; i++){
            if(!vis[0][i] && grid[0][i] == 1){
                dfs(0, i, vis, grid, n, m);
            }
            if(!vis[n-1][i] && grid[n-1][i] == 1){
                dfs(n-1, i, vis, grid, n, m);
            }
        }

        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int r, int c, boolean[][] vis, int[][] grid, int n, int m){
        if(r<0 || c<0 || r>=n || c>=m || vis[r][c] || grid[r][c] == 0) return;

        vis[r][c] = true;

        dfs(r+1, c, vis, grid, n, m);
        dfs(r-1, c, vis, grid, n, m);
        dfs(r, c+1, vis, grid, n, m);
        dfs(r, c-1, vis, grid, n, m);
    }
}