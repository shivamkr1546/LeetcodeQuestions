class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0 , -1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];
                for(int j=0; j<4; j++){
                    int nrow = r + drow[j];
                    int ncol = c + dcol[j];
                    if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && mat[nrow][ncol] == -1){
                        mat[nrow][ncol] = mat[pos[0]][pos[1]] + 1;
                        q.offer(new int[]{nrow, ncol});
                    }
                }
            }
        }

        return mat;
    }
}