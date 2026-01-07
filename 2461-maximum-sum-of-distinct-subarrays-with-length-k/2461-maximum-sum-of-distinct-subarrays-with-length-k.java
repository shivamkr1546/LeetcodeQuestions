class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long max = 0;
        long sum = 0;

        Set<Integer> st = new HashSet<>();

        int i=0;
        int j=0;

        while(j < n){
            while(st.contains(nums[j])){
                sum -= nums[i];
                st.remove(nums[i]);
                i++;
            }

            sum += nums[j];
            st.add(nums[j]);

            if(j-i+1 == k){
                max = Math.max(max, sum);
                sum -= nums[i];
                st.remove(nums[i]);
                i++;
            }
            j++;
        }

        return max;
    }
}