class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];

        
        for (int i = 0; i <= n; i++) {
            minRow[i] = n + 1;
            minCol[i] = n + 1;
        }

        
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            maxRow[y] = Math.max(maxRow[y], x);
            minRow[y] = Math.min(minRow[y], x);

            maxCol[x] = Math.max(maxCol[x], y);
            minCol[x] = Math.min(minCol[x], y);
        }

        int res = 0;

        
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            if (x > minRow[y] && x < maxRow[y] &&
                y > minCol[x] && y < maxCol[x]) {
                res++;
            }
        }

        return res;
    }
}
