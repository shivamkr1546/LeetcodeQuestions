class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean[] vis = new boolean[n + 1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            if (dfs(u, -1, vis, adj)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, node, vis, adj)) {
                    return true;
                }
            }
            
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
