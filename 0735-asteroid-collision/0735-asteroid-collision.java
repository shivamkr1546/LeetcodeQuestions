class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> st = new Stack<>();

        for (int x : a) {
            boolean alive = true;

            while (alive && !st.isEmpty() && st.peek() > 0 && x < 0) {

                if (Math.abs(x) > st.peek()) {
                    st.pop();
                } 
                else if (Math.abs(x) == st.peek()) {
                    st.pop();
                    alive = false;
                } 
                else {
                    alive = false;
                }
            }

            if (alive) st.push(x);
        }

        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
