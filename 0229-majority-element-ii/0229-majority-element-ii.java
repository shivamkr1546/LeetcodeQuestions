class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==1){
            res.add(nums[0]);
            return res;
        }
        for(int i=0; i<nums.length; i++){
            if(!res.contains(nums[i])){
                int cnt = 0;
                for(int j=0; j<nums.length; j++){
                    if(nums[j] == nums[i]){
                        cnt++;
                    }
                }
                if(cnt > nums.length/3){
                    res.add(nums[i]);
                }
            }
            
        }
        return res;
    }
}