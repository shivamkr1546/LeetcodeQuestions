class Solution {
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; 
        long oddCount = n / 2;   

        long res = modPow(5, evenCount) % MOD;
        res = (res * modPow(4, oddCount)) % MOD;

        return (int) res;
    }

    long modPow(long x, long n) {
        if (n == 0) return 1;
        long half = modPow(x, n / 2);
        long ans = (half * half) % MOD;
        if (n % 2 == 1) ans = (ans * x) % MOD;
        return ans;
    }
}
