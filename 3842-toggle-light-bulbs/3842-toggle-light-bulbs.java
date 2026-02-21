class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> res = new ArrayList<>();
        for(int bulb : bulbs){
            if(res.contains(bulb)){
                res.remove(Integer.valueOf(bulb));
            }else{
                res.add(bulb);
            }
        }
        Collections.sort(res);
        return res;
    }
}