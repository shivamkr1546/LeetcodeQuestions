class Solution {
    public int countPartitions(int[] nums) {
        int cnt = 0;
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for(int i=0; i<nums.length - 1; i++){
            sum += nums[i];
            int s = total - sum;
            if((sum - s)%2==0) cnt++;
        }
        return cnt;
    }
}