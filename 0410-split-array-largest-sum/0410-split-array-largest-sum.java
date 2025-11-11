class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int i=0; i<n; i++){
            lo = Math.max(lo, nums[i]);
            hi += nums[i];
        }

        return binarySearch(nums, k, lo, hi);
    }

    public int binarySearch(int[] arr, int k, int lo, int hi){
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(check(arr, mid) <= k) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return lo;
    }

    public int check(int[] arr, int pages){
        int cntStu = 1;
        int pageStu = 0;
        
        for(int i=0; i<arr.length; i++){
            if(pageStu + arr[i] <= pages){
                pageStu += arr[i];
            }else{
                cntStu++;
                pageStu = arr[i];
            }
        }
        
        return cntStu;
    }
}