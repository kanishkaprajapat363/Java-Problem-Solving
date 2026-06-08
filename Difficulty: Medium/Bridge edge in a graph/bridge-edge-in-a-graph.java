import java.util.*;

class Solution {
    
    private int timer;
    private boolean isBridge;
    
    private void dfs(int node, int parent,
                     ArrayList<ArrayList<Integer>> adj,
                     int[] tin, int[] low,
                     boolean[] vis,
                     int c, int d) {
        
        vis[node] = true;
        tin[node] = low[node] = timer++;
        
        for (int neigh : adj.get(node)) {
            
            if (neigh == parent)
                continue;
            
            if (!vis[neigh]) {
                dfs(neigh, node, adj, tin, low, vis, c, d);
                
                low[node] = Math.min(low[node], low[neigh]);
                
                // Check bridge condition
                if (low[neigh] > tin[node]) {
                    if ((node == c && neigh == d) ||
                        (node == d && neigh == c)) {
                        isBridge = true;
                    }
                }
            } else {
                low[node] = Math.min(low[node], tin[neigh]);
            }
        }
    }
    
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        timer = 0;
        isBridge = false;
        
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, adj, tin, low, vis, c, d);
            }
        }
        
        return isBridge;
    }
}