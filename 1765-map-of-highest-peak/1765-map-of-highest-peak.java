class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isWater[i][j] == 1){
                    vis[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];

            for(int i=0; i<4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !vis[nRow][nCol]){
                    vis[nRow][nCol] = true;
                    dist[nRow][nCol] = dist[row][col] + 1;
                    q.offer(new int[]{nRow, nCol});
                }
            }
        }

        return dist;
    }
}