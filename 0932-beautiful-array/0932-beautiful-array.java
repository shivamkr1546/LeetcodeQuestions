class Solution {
    static Map<Integer, int[]> memo = new HashMap<>();
    public int[] beautifulArray(int n) {
        if (memo.containsKey(n)) return memo.get(n);

        
        if (n == 4) return new int[]{3, 1, 2, 4};
        if (n == 5) return new int[]{3, 5, 1, 2, 4};

        int[] res = new int[n];
        if (n == 1) {
            res[0] = 1;
        } else {
            int[] left = beautifulArray((n + 1) / 2);  
            int[] right = beautifulArray(n / 2);       

            int idx = 0;

            for (int x : left) {
                res[idx++] = 2 * x - 1;
            }

            
            for (int x : right) {
                res[idx++] = 2 * x;
            }
        }

        memo.put(n, res);
        return res;
    }
}