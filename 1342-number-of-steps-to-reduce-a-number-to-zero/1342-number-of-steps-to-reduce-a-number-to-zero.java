class Solution {
    public int numberOfSteps(int num) {
        return recur(num, 0);
    }

    public int recur(int n, int steps){
        if(n==0) return steps;

        if(n%2==0) return recur(n/2, steps+1);
        return recur(n-1, steps+1);
    }
}