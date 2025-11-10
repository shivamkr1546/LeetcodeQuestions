class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        for(int d : bloomDay){
            l = Math.min(l , d);
            h = Math.max(h , d);
        }        
        return binarySearch(bloomDay, m, k, l, h);
    }

    public int binarySearch(int[] bloomDay, int m, int k, int l, int h){
        int ans = -1;
        while(l<=h){
            int days = l + (h - l)/2;
            if(check(bloomDay, days, m, k) >= m){
                ans = days;
                h = days - 1;
            }else{
                l = days + 1;
            }
        }
        return ans;
    }

    public int check(int[] bloomDay, int days, int m, int k){
        int cnt = 0;
        int b = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= days){
                cnt++;
                if(cnt == k){
                    b++;
                    cnt = 0;
                }
            }else{
                cnt = 0;
            }
        }
        return b;
    }
}