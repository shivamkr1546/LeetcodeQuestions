class Solution {
    public int smallestDivisor(int[] nums, int t) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;

        for(int n : nums){
            lo = Math.min(lo, n);
            hi = Math.max(hi, n);
        }

        return binarySearch(nums, t, lo, hi);
    }

    public int binarySearch(int[] nums, int t, int lo, int hi){
        while(lo<=hi){
            int divisor = lo + (hi - lo)/2;
            if(checkThres(nums, divisor) <= t){
                hi = divisor - 1;
            }else{
                lo = divisor + 1;
            }
        }
        return lo;
    }

    public int checkThres(int[] nums, int div){
        int sum = 0;
        for(int n : nums){
            sum += Math.ceil(n/(double)div);
        }
        return sum;
    }
}