class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        findCount(nums, target, 0, 0);
        return count;
    }

    public void findCount(int[] nums, int target, int sum, int index) {
        if(index==nums.length) {
            if(sum==target) {
                count++;
            }
            return;
        }
        findCount(nums, target, sum+nums[index], index+1);
        findCount(nums, target, sum-nums[index], index+1);
    }
}