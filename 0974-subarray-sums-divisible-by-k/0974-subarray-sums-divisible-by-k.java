class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int total = 0;
        int cnt = 0;

        for(int i=0; i<nums.length; i++){
            total += nums[i];
            int rem = ((total % k) + k) % k;
            cnt += mp.getOrDefault(rem, 0);
            mp.put(rem, mp.getOrDefault(rem, 0) + 1);

        }

        return cnt;
    }
}