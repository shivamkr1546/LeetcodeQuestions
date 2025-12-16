class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];

        for(int i=0; i<v; i++) color[i] = -1;

        for(int i=0; i<v; i++){
            if(color[i] == -1){
                if(!check(i, 0, graph, color)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean check(int node, int col, int[][] graph, int[] color){
        color[node] = col;

        for(int neighbour : graph[node]){
            if(color[neighbour] == -1){
                if(!check(neighbour, 1 - col, graph, color)){
                    return false;
                }
            }else if(color[neighbour] == col){
                return false;
            }
        }
        return true;
    }
}