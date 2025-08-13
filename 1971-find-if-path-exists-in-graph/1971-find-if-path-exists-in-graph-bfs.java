class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];

        return hasPath(adj, vis, source, destination);
    }

    public boolean hasPath(List<List<Integer>> adj, boolean[] vis, int src, int dest){
        if(src == dest) return true;

        vis[src] = true;

        for(int neighbor : adj.get(src)){
            if(!vis[neighbor] && hasPath(adj, vis, neighbor, dest)){
                return true;
            }
        }
        return false;
    }
}