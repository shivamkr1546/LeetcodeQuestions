class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] ans = new int[nums.length];
        int i = nums.length-1;
        while(l<=r){
            int n1 = nums[l]*nums[l];
            int n2 = nums[r]*nums[r];

            if(n1 > n2){
                ans[i--] = n1;
                l++;
            }else{
                ans[i--] = n2;
                r--;
            }
        }

        return ans;
        

    }
}