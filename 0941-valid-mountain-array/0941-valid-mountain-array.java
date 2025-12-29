class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int l = 0;
        int h = arr.length - 1;
        while(l < h){
            if(arr[l] < arr[l+1]){
                l++;
            }else if(arr[h - 1] > arr[h]){
                h--;
            }else{
                break;
            }
        }
        return l != 0 && h != arr.length - 1 && l == h;
    }
}