class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        int l = 0;
        int r = arr.length - 1;
        for(int i=0; i<arr.length; i++){
            arr[i] = reverse(arr[i]);
        }

        return String.join(" ", arr);
    }

    public String reverse(String str){
        char[] arr = str.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
        char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        return new String(arr);

    }
}