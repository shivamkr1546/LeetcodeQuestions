class Solution {
    int edge = 0;
    public void helper(int[][] grid, int i, int j, int r, int c){
        if(i-1<0 || grid[i-1][j]==0){
            edge++;
        }
        if(i+1>=r || grid[i+1][j]==0){
            edge++;
        }
        if(j+1>=c || grid[i][j+1]==0){
            edge++;
        }
        if(j-1<0 || grid[i][j-1]==0){
            edge++;
        }
    }
    public int islandPerimeter(int[][] grid) {
        edge = 0;
        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                    helper(grid, i, j, r, c);
                }
            }
        }
        return edge;
    }
}