class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        int sum = 0;
        for(int n : nums){
            sum += n;
            int r = n % 3;
            if(r == 1) r1.add(n);
            else if(r == 2) r2.add(n);
        }

        Collections.sort(r1);
        Collections.sort(r2);

        if(sum % 3 == 0) return sum;

        if (sum % 3 == 1) {
            int opt1 = r1.size() >= 1 ? r1.get(0) : Integer.MAX_VALUE; // smallest ele with rem 1
            int opt2 = r2.size() >= 2 ? r2.get(0) + r2.get(1) : Integer.MAX_VALUE; // 2 smallest ele with rem 2
            return sum - Math.min(opt1, opt2);
        }

        int opt1 = r2.size() >= 1 ? r2.get(0) : Integer.MAX_VALUE;
        int opt2 = r1.size() >= 2 ? r1.get(0) + r1.get(1) : Integer.MAX_VALUE;
        return sum - Math.min(opt1, opt2);


    }
}