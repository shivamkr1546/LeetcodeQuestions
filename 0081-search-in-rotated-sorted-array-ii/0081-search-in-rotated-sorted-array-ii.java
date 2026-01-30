class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo<=hi){
            int mid = lo + (hi - lo)/2;

            if(nums[mid] == target) return true;
            if(nums[lo] == nums[mid] && nums[mid] == nums[hi]){
                lo++;
                hi--;
                continue;
            }
            if(nums[lo] <= nums[mid]){
                //left half is sorted
                if(nums[lo] <= target && target <= nums[mid]){
                    //target is in left part
                    hi = mid - 1;
                }else{
                    //target is in right part
                    lo = mid + 1;
                }
            }else{
                //right half is sorted
                if(nums[mid] <= target && target <= nums[hi]){
                    //target is in right part
                    lo = mid + 1;
                }else{
                    //target is in left part
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}