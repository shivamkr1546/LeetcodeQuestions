class Solution {
    public int smallestRepunitDivByK(int k) {
        int curr = 1;
        int res = 1;

        Set<Integer> prev = new HashSet<>();
        while(curr % k > 0){
            int rem = curr % k;
            if(prev.contains(rem)) return -1;
            prev.add(rem);
            curr = rem * 10 + 1;
            res++;
        }

        return res;
    }
}