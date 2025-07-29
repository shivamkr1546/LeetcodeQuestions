class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Step 1: DFS from border 1s
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0)
                dfs(i, 0, grid, vis, dr, dc);
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0)
                dfs(i, m - 1, grid, vis, dr, dc);
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0)
                dfs(0, j, grid, vis, dr, dc);
            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0)
                dfs(n - 1, j, grid, vis, dr, dc);
        }

        // Step 2: Count all 1s not visited
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1 && vis[i][j] == 0)
                    count++;

        return count;
    }

    void dfs(int r, int c, int[][] grid, int[][] vis, int[] dr, int[] dc) {
        vis[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length
                && grid[nr][nc] == 1 && vis[nr][nc] == 0)
                dfs(nr, nc, grid, vis, dr, dc);
        }
    }
}
