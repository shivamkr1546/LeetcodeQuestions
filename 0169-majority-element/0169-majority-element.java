class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int majority = 0;
        
        for (int n : nums) {
            if (majority == 0) {
                res = n;
            }
            if(n == res){
                majority += 1;
            }else{
                majority -= 1;
            } 
        }
        
        return res;        
    }
}