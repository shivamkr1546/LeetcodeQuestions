class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.offer(i);
        }

        while(q.size() > 1){
            for(int cnt = 1; cnt<k; cnt++){
                int ele = q.poll();
                q.offer(ele);
            }

            q.poll();
        }

        return q.peek();
    }
}