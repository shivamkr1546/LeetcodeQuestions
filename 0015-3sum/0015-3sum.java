class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            Set<Integer> hashSet = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int k = -(nums[i] + nums[j]);
                if(hashSet.contains(k)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], k);
                    temp.sort(null);
                    st.add(temp);
                }
                hashSet.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}