class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int can1 = 0, can2 = 0;
        int lead1 = 0, lead2 = 0;

        for(int i=0; i<nums.length; i++){
            if(lead1 == 0 && can2 != nums[i]){
                lead1++;
                can1 = nums[i];
            }
            else if(lead2 == 0 && can1 != nums[i]){
                lead2++;
                can2 = nums[i];
            }
            else if(nums[i] == can1) lead1++;
            else if(nums[i] == can2) lead2++;
            else{
                lead1--;
                lead2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == can1) cnt1++;
            if(nums[i] == can2) cnt2++;
        }
        
        if(cnt1 > nums.length/3) ans.add(can1);
        if(cnt2 > nums.length/3){
            if(!ans.contains(can2)) ans.add(can2);
        }
        return ans;
    }
}