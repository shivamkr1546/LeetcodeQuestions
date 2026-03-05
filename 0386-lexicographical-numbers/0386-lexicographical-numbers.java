class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int currNum = 1; currNum<=9; currNum++){
            solve(currNum, n, res);
        }

        return res;
    }

    public void solve(int currNum, int n, List<Integer> res){
        if(currNum > n){
            return;
        }
        
        res.add(currNum);

        for(int append = 0; append <= 9; append++){
            int newNum = (currNum * 10) + append;

            if(newNum > n){
                break;
            }

            solve(newNum, n, res);
        }
    }
}