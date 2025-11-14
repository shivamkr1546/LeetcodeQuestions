class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int idx = 0;
        int maxOnes = -1;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int x : mat[i]) {
                if (x == 1) count++;
            }
            
            if (count > maxOnes) {
                maxOnes = count;
                idx = i;
            }
        }

        return new int[]{idx, maxOnes};
    }
}
