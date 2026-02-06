class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int i = 0;
        int maxKeep = 1;

        for (int j = 0; j < n; j++) {

            while ((long) nums[j] > (long) nums[i] * k) {
                i++;  
            }

            maxKeep = Math.max(maxKeep, j - i + 1);
        }

        return n - maxKeep;
    }
}
