class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        int sum = 0;
        double avg = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }

        avg = (double)sum/k;
        maxAvg = Math.max(avg, maxAvg);

        for(int i=k; i<nums.length; i++){
            sum += nums[i];
            sum -= nums[i-k];

            avg = (double) sum/k;
            maxAvg = Math.max(avg, maxAvg);
        }

        return maxAvg;
    }
}