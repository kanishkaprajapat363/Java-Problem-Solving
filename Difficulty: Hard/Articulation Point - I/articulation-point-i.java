class Solution {

    int timer;

    private void dfs(int node, int parent,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] vis,
                     int[] tin,
                     int[] low,
                     boolean[] isArticulation) {

        vis[node] = true;
        tin[node] = low[node] = timer++;

        int children = 0;

        for (int neigh : adj.get(node)) {

            if (neigh == parent)
                continue;

            if (!vis[neigh]) {

                dfs(neigh, node, adj, vis, tin, low, isArticulation);

                low[node] = Math.min(low[node], low[neigh]);

                // Non-root articulation point
                if (parent != -1 && low[neigh] >= tin[node]) {
                    isArticulation[node] = true;
                }

                children++;

            } else {

                low[node] = Math.min(low[node], tin[neigh]);
            }
        }

        // Root articulation point
        if (parent == -1 && children > 1) {
            isArticulation[node] = true;
        }
    }

    public ArrayList<Integer> articulationPoints(
            int V, ArrayList<ArrayList<Integer>> adj) {

        timer = 0;

        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] isArticulation = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, adj, vis, tin, low, isArticulation);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) {
                ans.add(i);
            }
        }

        if (ans.size() == 0) {
            ans.add(-1);
        }

        return ans;
    }
}