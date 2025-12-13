class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        int v = isConnected.length;

        boolean[] vis = new boolean[v];

        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(i, vis, isConnected);
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int node, boolean[] vis, int[][] isConnected){
        vis[node] = true;

        for(int i = 0; i<isConnected.length; i++){
            if(isConnected[node][i] == 1 && vis[i] == false){
                dfs(i, vis, isConnected);
            }
        }
    }
}