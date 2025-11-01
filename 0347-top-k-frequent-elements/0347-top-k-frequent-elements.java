class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        List<Integer> arr = new ArrayList<>(mp.keySet());
        Collections.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return mp.get(b) - mp.get(a);
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}