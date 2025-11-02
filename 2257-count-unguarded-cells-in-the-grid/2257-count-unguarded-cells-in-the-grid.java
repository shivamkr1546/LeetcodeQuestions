class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        for(int[] g : guards){
            grid[g[0]][g[1]] = 'G';
        }

        for(int[] w : walls){
            grid[w[0]][w[1]] = 'W';
        }

        boolean[][] seen = new boolean[m][n];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int[] g : guards){
            int r = g[0], c = g[1];
            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                while(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    if(grid[nr][nc] == 'W' || grid[nr][nc] == 'G') break;
                    seen[nr][nc] = true;
                    nr += d[0];
                    nc += d[1];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.' && !seen[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}