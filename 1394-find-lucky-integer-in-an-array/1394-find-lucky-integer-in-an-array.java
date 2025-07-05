class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: arr){
            int count = map.getOrDefault(ele, 0);
            map.put(ele, count+1);
        }

        int luckyInteger = -1;

        for(int key: map.keySet()){
            if(map.get(key) ==  key){
                luckyInteger = key;
            }
        }

        return luckyInteger;
    }
}