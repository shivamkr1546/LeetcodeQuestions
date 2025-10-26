class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> res = new HashMap<>();
        for(int i=0; i<n; i++){
            int val = res.getOrDefault(nums[i], 0);
            res.put(nums[i], val + 1);
        }

        for(Map.Entry<Integer, Integer> entry : res.entrySet()){
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }

        return -1;
    }
}