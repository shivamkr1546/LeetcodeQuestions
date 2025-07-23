class Solution {
    public int findCircleNum(int[][] adj) {
        boolean[] vis = new boolean[adj.length];
        int cnt = 0;
        for(int i=0; i<adj.length; i++){
            if(!vis[i]){
                dfs(i, vis, adj);
                cnt++;
            }
        }

        return cnt;
    }

    public void dfs(int i, boolean[] vis, int[][] adj){
        vis[i] = true;
        
        for(int j=0; j<adj.length; j++){
            if(adj[i][j] == 1 && vis[j] == false){
                vis[j] = true;
                dfs(j, vis, adj);
            }
        }
    }
}