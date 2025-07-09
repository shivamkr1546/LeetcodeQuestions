class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int currCnt = 0;
            while(num>0){
                int rem = num % 10;
                currCnt++;
                num /= 10;
            }
            if(currCnt % 2 == 0){
                cnt++;
            }
        }
        return cnt;
    }
}