class Solution {
    public void bfs(int i, boolean[] vis, int[][] adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int j=0; j<adj.length; j++){
                if(!vis[j] && adj[node][j]==1){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                bfs(i, vis, isConnected);
                cnt++;
            }
        }

        return cnt;
    }
}