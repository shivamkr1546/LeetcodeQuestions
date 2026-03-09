class Solution {
    public int punishmentNumber(int n) {
        int punish = 0;

        for(int num = 1; num <= n; num++){
            int sq = num * num;

            String s = String.valueOf(sq);
            if(check(s, num, 0, 0)){
                punish += sq;
            }
        }

        return punish;
    }

    public boolean check(String str, int num, int i, int currSum){
        if(i == str.length()){
            return currSum == num;
        }

        if(currSum > num){
            return false;
        }

        boolean possible = false;

        for(int j = i; j < str.length(); j++){
            String sub = str.substring(i, j + 1);
            int val = Integer.parseInt(sub);

            possible = possible || check(str, num, j + 1, currSum + val);

            if(possible){
                return true;
            }
        }

        return possible;
    }
}