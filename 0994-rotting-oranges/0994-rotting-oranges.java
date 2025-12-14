class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length, c = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[r][c];
        int cntFresh = 0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = 2;
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                    vis[i][j] = 0;
                }
            }
        }

        int tm = 0, cnt = 0;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] pos = q.poll();
            int row = pos[0], col = pos[1], t = pos[2];
            tm = Math.max(tm, t);

            for(int i=0; i<4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nCol >= 0&& nRow < r && nCol < c && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0){
                    q.offer(new int[]{nRow, nCol, t+1});
                    vis[nRow][nCol] = 2;
                    cnt++;
                }
            }
        }

        return (cnt == cntFresh) ? tm : -1;
    }
}