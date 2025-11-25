class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0;
        int r = people.length - 1;
        Arrays.sort(people);
        int cnt = 0;
        while(l<=r){
            if(people[l] + people[r] <= limit){
                l++;
            }
            r--;
            cnt++;
        }
        return cnt;
    }
}