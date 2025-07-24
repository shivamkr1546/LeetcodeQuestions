class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return hasPath(adj, source, destination, new boolean[n]);
    }

    public boolean hasPath(List<List<Integer>> adj, int src, int dest, boolean vis[]){
        if(src==dest){
            return true;
        }

        vis[src] = true;
        for(int neighbour : adj.get(src)){
            if(!vis[neighbour] && hasPath(adj, neighbour, dest, vis)){
                return true;
            }
        }

        return false;
    }
}