class Solution {
    public int subarraySum(int[] a, int k) {
        Map<Long, Integer> presumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for(int i=0; i<a.length; i++){
            sum += a[i];

            if(sum == k) maxLen = Math.max(maxLen, i+1);

            long rem = sum - k;
            if(presumMap.containsKey(rem)){
                int len = i - presumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            presumMap.putIfAbsent(sum, i);
        }
        return maxLen;        
    }
}