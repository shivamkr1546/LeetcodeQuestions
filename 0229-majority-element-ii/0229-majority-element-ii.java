class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() > nums.length/3) ans.add(entry.getKey());
        }
        return ans;
    }
}