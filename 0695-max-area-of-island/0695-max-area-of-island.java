class Solution {
    public int dfs(int[][] grid, int i, int j, int r, int c){
        if(i<0 || j<0 || i==r || j==c || grid[i][j]==0) return 0;
        grid[i][j] = 0;

        return 1 + dfs(grid, i, j-1, r, c)
         + dfs(grid, i, j+1, r, c)
         + dfs(grid, i+1, j, r, c)
         + dfs(grid, i-1, j, r, c);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int area = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                    int a = dfs(grid, i, j, r, c);
                    area = Math.max(area, a);
                }
            }
        }

        return area;
    }
}