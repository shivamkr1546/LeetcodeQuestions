class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();

        int i=0;
        int j=0;

        // 1, 0, 1, 1  k = 1;
        // i
        //    j
        //<1, 0>

        while(j<nums.length){
            if(st.contains(nums[j])) return true;

            st.add(nums[j]);

            if(j-i>=k){
                st.remove(nums[i]);
                i++;
            }
            j++;
        }

        return false;
    }
}