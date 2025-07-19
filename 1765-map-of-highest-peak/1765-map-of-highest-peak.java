class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int r = isWater.length;
        int c = isWater[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize water cells as 0 and land as -1
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(isWater[i][j] == 1) {
                    isWater[i][j] = 0;  // Water height is 0
                    queue.offer(new int[]{i, j});
                } else {
                    isWater[i][j] = -1; // Mark unvisited land
                }
            }
        }
        
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        // Step 2: BFS to assign heights
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int[] dir : directions){
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];

                if(x >= 0 && y >= 0 && x < r && y < c && isWater[x][y] == -1){
                    isWater[x][y] = isWater[pos[0]][pos[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return isWater;
    }
}
