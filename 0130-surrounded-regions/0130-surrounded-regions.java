class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(i, 0, vis, board);
            }
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs(i, m-1, vis, board);
            }
        }

        for(int j=0; j<m; j++){
            if(!vis[0][j] && board[0][j] == 'O'){
                dfs(0, j, vis, board);
            }
            if(!vis[n-1][j] && board[n-1][j] == 'O'){
                dfs(n-1, j, vis, board);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
            
            
        }
    }

    public void dfs(int r, int c, boolean[][] vis, char[][] board){
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        vis[r][c] = true;
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<4; i++){
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !vis[nRow][nCol] && board[nRow][nCol] == 'O'){
                dfs(nRow, nCol, vis, board);
            }
        }
    }
}