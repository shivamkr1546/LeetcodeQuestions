class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                cnt = 0;
                for(int j =i+1; j<nums.length; j++){
                    if(nums[j] != 1) cnt++;
                    else{
                        if(cnt < k) return false;
                        cnt = 0;
                    }
                }
            }
        }

        return true;
    }
}