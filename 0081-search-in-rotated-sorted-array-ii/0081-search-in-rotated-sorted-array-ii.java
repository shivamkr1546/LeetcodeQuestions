class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while(l<=h){
            int mid = l + (h - l)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[l] == nums[mid] && nums[mid] == nums[h]){
                l++;
                h--;
                continue;
            }
            if(nums[l] <= nums[mid]){ //left part is sorted
                if(nums[l] <= target && target <= nums[mid]){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] <= target && nums[h] >= target){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }
            }
        }
        return false;
    }
}