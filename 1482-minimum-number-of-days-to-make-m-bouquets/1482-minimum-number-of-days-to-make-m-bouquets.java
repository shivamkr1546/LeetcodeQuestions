class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int d : bloomDay){
            min = Math.min(min, d);
            max = Math.max(max, d);
        }

        return binarySearch(bloomDay, m, k, min, max);
    }

    public int binarySearch(int[] bloomDay, int m, int k, int min, int max){
        int minDays = -1;
        while(min <= max){
            int days = min + (max - min)/2;
            if(check(bloomDay, m, k, days) >= m){
                minDays = days;
                max = days - 1;
            }else{
                min = days + 1;
            }
        }
        return minDays;
    }

    public int check(int[] bloomDay, int m, int k, int day){
        int cnt = 0;
        int b = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= day){
                cnt++;
            }else{
                cnt=0;
            }
            if(cnt == k){
                b++;
                cnt = 0;
            }
        }
        return b;
    }
}