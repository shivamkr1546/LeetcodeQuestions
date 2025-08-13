class Solution {
    public void dfs(char[][] grid, int row, int col, int maxRow, int maxCol){
        if(row < 0 || row >= maxRow || col < 0 || col >= maxCol || grid[row][col]=='0') return;

        grid[row][col] = '0';

        dfs(grid, row + 1, col, maxRow, maxCol);
        dfs(grid, row - 1, col, maxRow, maxCol);
        dfs(grid, row, col + 1, maxRow, maxCol);
        dfs(grid, row, col - 1, maxRow, maxCol);
    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int cnt = 0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, r, c);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}