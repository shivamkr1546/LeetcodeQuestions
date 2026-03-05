class Solution {
    public List<Integer> solve(String exp){
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<exp.length(); i++){
            char c = exp.charAt(i);

            if(c == '-' || c == '+' || c == '*'){
                List<Integer> left = solve(exp.substring(0, i));
                List<Integer> right = solve(exp.substring(i+1));

                for (int x : left) {
                    for (int y : right) {
                        if (c == '+') {
                            result.add(x + y);
                        } else if (c == '-') {
                            result.add(x - y);
                        } else {
                            result.add(x * y);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(exp));
        }

        return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
}