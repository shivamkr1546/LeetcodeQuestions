class Solution {
    public double myPow(double x, int n) {
        return pow(x, (long) n);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / pow(x, -n);
        double half = pow(x, n / 2);
        if (n % 2 == 0) return half * half;
        return half * half * x;
    }
}
