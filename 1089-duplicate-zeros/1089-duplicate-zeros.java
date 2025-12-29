class Solution {
    public void duplicateZeros(int[] arr) {
        int pzd = 0;
        int lastIdx = arr.length - 1;

        for(int i=0; i<=lastIdx - pzd; i++){
            if(arr[i] == 0){
                if(i == lastIdx - pzd){
                    arr[lastIdx] = 0;
                    lastIdx -= 1;
                    break;
                }
                pzd++;
            }
        }


        int newLastIdx = lastIdx - pzd;
        for(int i=newLastIdx; i>=0; i--){
            if(arr[i] == 0){
                arr[i+pzd] = 0;
                pzd--;
                arr[i+pzd] = 0;
            }else{
                arr[i+pzd] = arr[i];
            }
        }
    }
}