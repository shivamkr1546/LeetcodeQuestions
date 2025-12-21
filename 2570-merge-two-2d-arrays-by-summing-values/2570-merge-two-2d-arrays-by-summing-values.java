class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] ans = new int[n+m][2];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i][0] == nums2[j][0]){
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1] + nums2[j][1];
                k++;
                i++;
                j++;
            }else if(nums1[i][0] < nums2[j][0]){
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1];
                k++;
                i++;
            }else{
                ans[k][0] = nums2[j][0];
                ans[k][1] = nums2[j][1];
                k++;
                j++;
            }
        }

        while(i<nums1.length){
            ans[k][0] = nums1[i][0];
            ans[k][1] = nums1[i][1];
            k++;
            i++;
        }

        while(j<nums2.length){
            ans[k][0] = nums2[j][0];
            ans[k][1] = nums2[j][1];
            k++;
            j++;
        }
        
        int[][] temp = new int[k][2];
        for (int x = 0; x < k; x++) {
            temp[x] = ans[x];
        }

        return temp;
    }
}