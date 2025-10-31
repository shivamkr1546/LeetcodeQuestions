class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() ==  2){
                res.add(entry.getKey());
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}