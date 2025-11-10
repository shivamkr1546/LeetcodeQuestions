class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int h = Integer.MIN_VALUE;
        for(int n : nums){
            h = Math.max(h , n);
        }        
        return binarySearch(nums, threshold, l, h);
    }

    public int binarySearch(int[] nums, int t, int l, int h){
        int ans = -1;
        while(l<=h){
            int d = l + (h - l)/2;
            if(check(nums, d) <= t){
                ans = d;
                h = d - 1;
            }else{
                l = d + 1;
            }
        }
        return ans;
    }

    public int check(int[] nums, int d){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += Math.ceil(nums[i]/(double)d);
        }
        return sum;
    }
}