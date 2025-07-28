class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Push all 0s into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        // Directions for up, right, down, left
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                // Only process unvisited 1s
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !vis[nrow][ncol]) {
                    dist[nrow][ncol] = dist[row][col] + 1;
                    vis[nrow][ncol] = true;
                    q.offer(new int[]{nrow, ncol});
                }
            }
        }

        return dist;
    }
}
