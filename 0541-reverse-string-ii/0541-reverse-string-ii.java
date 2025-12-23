class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int i = 0;
        while (i < n) {
            int remaining = n - i;

            if (remaining >= 2 * k) {
                reverse(arr, i, i + k - 1);
                i += 2 * k;
            } 
            else if (remaining >= k) {
                reverse(arr, i, i + k - 1);
                break;
            } 
            else {
                reverse(arr, i, n - 1);
                break;
            }
        }

        return new String(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
