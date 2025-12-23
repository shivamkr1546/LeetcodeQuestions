class Solution {
    public boolean isHappy(int n) {
        Set<Integer> st = new HashSet<>();
        while(n!=1){
            if(st.contains(n)) return false;
            st.add(n);

            int temp = 0;
            while(n>0){
                int rem = n%10;
                temp += rem*rem;
                n/=10;
            }
            n = temp;
        }

        return true;
    }
}