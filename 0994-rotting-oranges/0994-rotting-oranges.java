class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if(fresh == 0) return 0;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int min = -1;

        while(!queue.isEmpty()){
            int size = queue.size();
            min++;
            for(int i=0; i<size; i++){
                int[] pos = queue.poll();
                for(int[] dir : directions){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];

                    if(x >= 0 && y >= 0 && x < r && y < c && grid[x][y] == 1){
                        grid[x][y] = 2;
                        fresh--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return fresh == 0 ? min : -1;
        
    }
}