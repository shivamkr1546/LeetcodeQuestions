class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 0) return 0;
        int curr = 0, longest = 1, lastSmallest = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i] == lastSmallest) continue;
            if(nums[i] - 1 == lastSmallest){
                curr++;
                lastSmallest = nums[i];
            }else if(nums[i] - 1 != lastSmallest){
                curr = 1;
                lastSmallest = nums[i];
            }
            longest = Math.max(curr, longest);
        }
        return longest;
    }
}