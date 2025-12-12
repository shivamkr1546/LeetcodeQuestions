class Solution {
    public void dfs(int node, boolean[] vis, int[][] adj){
        vis[node] = true;

        for(int j=0; j<adj.length; j++){
            if(!vis[j] && adj[node][j] == 1){
                dfs(j, vis, adj);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, vis, isConnected);
                cnt++;
            }
        }

        return cnt;
    }
}