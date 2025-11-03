class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int pre = 1, suff = 1;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;

            pre *= nums[i];
            suff *= nums[nums.length-i-1];

            ans = Math.max(ans, Math.max(suff, pre));
        }
        return ans;
    }
}