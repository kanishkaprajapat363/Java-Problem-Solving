// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        
        dist[src] = 0;
        
        // Relax all edges V-1 times
        for(int i = 0; i < V - 1; i++) {
            
            for(int[] edge : edges) {
                
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                if(dist[u] != (int)1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        // Check for negative weight cycle
        for(int[] edge : edges) {
            
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if(dist[u] != (int)1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }
        
        return dist;
    }
}