class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        // mid = 2^(N-2). safe because we return for N==1 above
        int mid = 1 << (N - 2);
        if (K <= mid) {
            return kthGrammar(N - 1, K);
        } else {
            return kthGrammar(N - 1, K - mid) ^ 1; // flip bit using XOR 1
        }
    }
}
