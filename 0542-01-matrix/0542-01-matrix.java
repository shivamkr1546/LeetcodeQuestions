class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int zero = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    grid[i][j] = -1;
                }
            }
        }
        
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] pos = queue.poll();
                for(int[] dir : directions){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];

                    if(x >= 0 && y >= 0 && x < r && y < c && grid[x][y] == -1){
                        grid[x][y] = grid[pos[0]][pos[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return grid;
    }
}