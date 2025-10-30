class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int total = 0, cnt = 0;
        for(int i=0; i<nums.length; i++){
            total += nums[i];
            if(preSum.containsKey(total-k)){
                cnt += preSum.get(total-k);
            }
            preSum.put(total, preSum.getOrDefault(total, 0)+1);
        }
        return cnt;
    }
}