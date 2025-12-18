class Solution {
    public boolean dfsCheck(int node, int[] vis, int[] path, int[][] adj, int[] check){
        vis[node] = 1;
        path[node] = 1;
        check[node] = 0;
        for(int it: adj[node]){
            if(vis[it] == 0){
                if(dfsCheck(it, vis, path, adj, check)==true){
                    check[node] = 0;
                    return true;
                }
            }else if(path[it] == 1){
                check[node] = 0;
                return true;
            }
        }
        check[node] = 1;
        path[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int vis[] = new int[V];
        int path[] = new int[V];
        int check[] = new int[V];
        List<Integer> safeNodes = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                dfsCheck(i,vis, path, graph, check);
            }
        }
        
        
        for(int i=0; i<V; i++){
            if(check[i]==1){
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }
}