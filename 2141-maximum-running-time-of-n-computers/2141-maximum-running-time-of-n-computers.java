class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int b:batteries){
            sum += b;   
        } 

        long l = 0; long r = sum/n;
        while(l < r){
            long mid = (r + l + 1) >> 1;
            long need = mid * n, have = 0;

            for(int b: batteries){
                have += Math.min(b, mid);
            }

            if(have >= need) l = mid;
            else r = mid - 1;
        }

        return l;
    }
}