class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        int n = nums.length / 2;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() == n){
                return entry.getKey();
            }
        }

        return 0;
    }
}