class Solution {
    public int majorityElement(int[] nums) {
        int maj = 0;
        int lead = 0;
    
        for(int i=0; i<nums.length; i++){
            if(lead==0) maj = nums[i];
            if(nums[i]==maj) lead++;
            else lead--;
        }

        return maj;
    }
}