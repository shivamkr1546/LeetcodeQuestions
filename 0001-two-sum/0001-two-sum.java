class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> res = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            int more = target - a;
            if(res.containsKey(more)){
                return new int[]{res.get(more), i};
            }
            res.put(nums[i], i);
        }
        return new int[]{};
    }
}