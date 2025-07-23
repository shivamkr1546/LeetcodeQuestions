class Solution {
    public int trap(int[] arr) {
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length]; 
        int trappedRainwater = 0;
        if(arr.length >= 2){
            leftMax[0] = arr[0];
            rightMax[arr.length-1] = arr[arr.length-1];
            for(int i=1; i<arr.length; i++){
                leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
            }
            for(int i=arr.length - 2; i>=0; i--){
                rightMax[i] = Math.max(rightMax[i+1], arr[i]);
            }
            
            for(int i=0; i<arr.length; i++){
                int waterLevel = Math.min(leftMax[i],rightMax[i]);
                trappedRainwater += (waterLevel - arr[i])*1;
            }

        }
        return trappedRainwater;
    }
}