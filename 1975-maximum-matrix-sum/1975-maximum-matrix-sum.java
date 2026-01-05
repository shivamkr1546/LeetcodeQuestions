class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long cnt = 0;
        long sum = 0;
        long minAbsVal = Long.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                long val = matrix[i][j];

                if (val < 0) {
                    cnt++;
                }

                long absVal = Math.abs(val);
                minAbsVal = Math.min(minAbsVal, absVal);
                sum += absVal;
            }
        }

        if (cnt % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * minAbsVal;
        }
    }
}
