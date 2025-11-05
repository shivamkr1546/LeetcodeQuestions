class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        if(n==0) return 0;
        int longest = 1;
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        for(int it : set){
            if(!set.contains(it - 1)){
                int cnt = 1;
                int x = it;
                while(set.contains(x + 1)){
                    x++;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}