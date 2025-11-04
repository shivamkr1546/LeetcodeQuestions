class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<=nums.length-k; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i; j<i+k; j++){
                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            }

            if(map.size() <= x){
                int sum = 0;
                for(int j=i; j<i+k; j++) sum+=nums[j];
                res.add(sum);
            }else{
                List<Map.Entry<Integer, Integer>> pairs = new ArrayList<>(map.entrySet());

                pairs.sort((a, b) -> {
                    if(!b.getValue().equals(a.getValue())) return b.getValue() - a.getValue();
                return b.getKey() - a.getKey();
                });

                int curSum = 0;
                // Take top x elements after sorting
                for (int j = 0; j < x && j < pairs.size(); j++) {
                    Map.Entry<Integer, Integer> entry = pairs.get(j);
                    curSum += entry.getKey() * entry.getValue();
                }

                res.add(curSum);
            }
        }

        int[] ans = new int[res.size()];
for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
return ans;

    }
}