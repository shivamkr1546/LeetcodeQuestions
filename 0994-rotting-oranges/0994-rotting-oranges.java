class Solution {
    public void dfs(int[][] grid, int i, int j, int min){
        if(i<0 || i>=grid.length
        || j<0 || j>=grid[0].length
        || grid[i][j] == 0
        || 1 < grid[i][j] && grid[i][j] < min){
            return;
        }

        grid[i][j] = min;
        dfs(grid, i, j+1, min+1);
        dfs(grid, i, j-1, min+1);
        dfs(grid, i+1, j, min+1);
        dfs(grid, i-1, j, min+1);
    }
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]==2){
                    dfs(grid, i, j, 2);
                }
            }
        }
        int min = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                min = Math.max(min, cell);
            }
        }
        
        return min - 2;

    }
}