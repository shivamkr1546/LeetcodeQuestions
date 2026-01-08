class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) return result;

        int first = firstOccur(nums, target);
        
        if (first == nums.length || nums[first] != target) {
            return result;
        }

        int last = lastOccur(nums, target);

        result[0] = first;
        result[1] = last;
        return result;
    }

    public int firstOccur(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;

        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] >= target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int lastOccur(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;

        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return lo - 1;
    }
}