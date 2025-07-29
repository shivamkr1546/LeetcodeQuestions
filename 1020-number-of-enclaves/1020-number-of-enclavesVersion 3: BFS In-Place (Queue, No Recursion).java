class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // DFS from border 1s, mark visited land as -1
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid);
            if (grid[i][m - 1] == 1) dfs(i, m - 1, grid);
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) dfs(0, j, grid);
            if (grid[n - 1][j] == 1) dfs(n - 1, j, grid);
        }

        // Count remaining land
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    count++;

        return count;
    }

    void dfs(int r, int c, int[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1)
            return;
        grid[r][c] = -1;

        dfs(r - 1, c, grid);
        dfs(r + 1, c, grid);
        dfs(r, c - 1, grid);
        dfs(r, c + 1, grid);
    }
}
