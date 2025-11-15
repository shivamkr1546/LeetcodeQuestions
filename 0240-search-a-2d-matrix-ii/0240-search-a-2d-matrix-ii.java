class Solution {
    public boolean binarySearch(int[] nums, int x){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == x) return true;
            else if(nums[mid] > x) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            if(binarySearch(matrix[i], target) == true) return true;
        }
        return false;
    }
}