class Solution {
    public boolean isBipartite(int[][] graph) {
        // List<List<Integer>> adj = new ArrayList<>();
        // for(int i)
        int V = graph.length;
        int color[] = new int[V];

        for(int i=0; i<V; i++) color[i] = -1;

        for(int i=0; i<V; i++){
            if(color[i]==-1){
                if(check(i, V, graph, color)==false){
                    return false;
                }
            }
        }
        
        return true;
    }

    private boolean check(int start, int V, int[][] adj, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()){
            int node = q.remove();

            for(int it:adj[node]){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }else if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}