class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(
            arr,(a, b) -> Integer.compare(a[0], b[0])
        );
        int start = arr[0][0];
        int end = arr[0][1];
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<arr.length; i++){
            int s = arr[i][0];
            int e = arr[i][1];

            if(s <= end){
                end = Math.max(e, end);
            }else{
                list.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);

    }
}