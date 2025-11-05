class Solution {
    private static int firstOccurance(int[] nums, int target){
        int l = 0;
        int h = nums.length - 1;
        int ans = -1;
        while(l<=h){
            int mid = l + (h - l)/2;
            if(nums[mid] == target){
                ans = mid;
                h = mid - 1;
            }
            else if(nums[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    private static int lastOccurance(int[] nums, int target){
        int l = 0;
        int h = nums.length - 1;
        int ans = -1;
        while(l<=h){
            int mid = l + (h - l)/2;
            if(nums[mid] == target){
                ans = mid;
                l = mid + 1;
            }
            else if(nums[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        result[0] = firstOccurance(nums, target);
        result[1] = lastOccurance(nums, target);
        return result;
    }
}