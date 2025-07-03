class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int minr = 0;
        int maxr = n-1;
        int minc = 0;
        int maxc = n-1;
        int cnt = 1;
        while(minr<=maxr && minc<=maxc){
            //right
            for(int j=minc; j<=maxc; j++){
                arr[minr][j] = cnt++;
            }
            minr++;
            if(minr>maxr || minc>maxc) break;

            //down
            for(int j=minr; j<=maxr; j++){
                arr[j][maxc] = cnt++;
            }
            maxc--;
            if(minr>maxr || minc>maxc) break;

            //left
            for(int j=maxc; j>=minc; j--){
                arr[maxr][j] = cnt++;
            }
            maxr--;
            if(minr>maxr || minc>maxc) break;

            //up
            for(int j=maxr; j>=minr; j--){
                arr[j][minc] = cnt++;
            }
            minc++;
            if(minr>maxr || minc>maxc) break;
        }
        return arr;
        
    }
}