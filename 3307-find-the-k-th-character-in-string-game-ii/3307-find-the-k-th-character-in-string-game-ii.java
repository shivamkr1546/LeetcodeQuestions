class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k==1) return 'a';

        int n = operations.length;
        long len = 1;
        int opType = -1;
        long newK = -1;
        for(int i=0; i<n; i++){
            len*=2;
            if(len >= k){
                opType = operations[i];
                newK = k - len/2;
                break;
            }
        }

        char ch = kthCharacter(newK, operations);
        if(opType == 0) return ch;
        else{
            if(ch=='z') return 'a';
            else return (char)(ch+1);
        }
    }
}