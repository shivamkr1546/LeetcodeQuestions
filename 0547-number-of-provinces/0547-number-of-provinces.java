class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int cnt = 0;
        boolean[] vis = new boolean[v];
        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(i, isConnected, vis);
                cnt++;
            }
        }

        return cnt;
    }

    public void dfs(int i, int[][] isConnected, boolean[] vis){
        vis[i] = true;
        for(int j=0; j<isConnected.length; j++){
            if(vis[j] == false && isConnected[i][j] == 1){
                dfs(j, isConnected, vis);
            }
        }
    }
}