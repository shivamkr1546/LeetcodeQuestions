class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0; i<image.length; i++){
            int lo = 0, hi = image[0].length-1;
            while(lo<=hi){
                if(image[i][lo] == image[i][hi]){
                    image[i][lo] = 1 - image[i][lo];
                    image[i][hi] = image[i][lo];
                }
                hi--;
                lo++;
            }
        }
        return image;
    }
}