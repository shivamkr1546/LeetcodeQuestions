class Solution {
    int size = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    size = 0;
                    int a = dfs(i, j, vis, grid, n, m);
                    max = Math.max(a, max);
                }
            }
        }
        return max;
    }

    public int dfs(int r, int c, boolean[][] vis, int[][] grid, int n, int m){
        if(r<0 || c<0 || r>=n || c>=m || vis[r][c] || grid[r][c] == 0) return 0;

        vis[r][c] = true;
        size++;

        dfs(r+1, c, vis, grid, n, m);
        dfs(r-1, c, vis, grid, n, m);
        dfs(r, c+1, vis, grid, n, m);
        dfs(r, c-1, vis, grid, n, m);

        return size;
    }
}