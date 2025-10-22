class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        int cnt = 0; 

        for(int i=0; i<nums.length; i++){
            int st = i;
            for(int j=i; j<nums.length; j++){
                int end = j;
                int currSum = st == 0 ? prefix[end] : prefix[end] - prefix[st-1];
                if(currSum == k) cnt++;
            }
        }
        return cnt;
    }
}