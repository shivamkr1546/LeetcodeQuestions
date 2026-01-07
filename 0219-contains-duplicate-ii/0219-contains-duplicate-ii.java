class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();

        for(int i=0; i<Math.min(k, nums.length); i++){
            if(st.contains(nums[i])) return true;
            st.add(nums[i]);
        }

        for(int i=k; i<nums.length; i++){
            if(st.contains(nums[i])) return true;

            st.add(nums[i]);
            st.remove(nums[i-k]);
        }

        return false;
    }
}