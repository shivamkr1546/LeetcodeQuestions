class Solution {
    public void duplicateZeros(int[] arr) {
        int zCnt = 0;
        int n = arr.length - 1;

        for(int i=0; i<=n - zCnt; i++){
            if(arr[i]==0){
                if(i == n - zCnt){
                    arr[n] = 0;
                    n -= 1;
                    break;
                }
                zCnt++;
            }
        }

        int newLastIdx = n - zCnt;
        for(int i=newLastIdx; i>=0; i--){
            if(arr[i] == 0){
                arr[i + zCnt] = 0;
                zCnt--;
                arr[i + zCnt] = 0;
            }else{
                arr[i + zCnt] = arr[i];
            }
        }
    }
}