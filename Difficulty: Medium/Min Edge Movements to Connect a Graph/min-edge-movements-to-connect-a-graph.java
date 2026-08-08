class Solution {
    int minEdgesReq(int n, int[][] edges) {
        
        // Not enough edges to ever form a connected graph
        if (edges.length < n - 1) {
            return -1;
        }

        boolean[] visited = new boolean[n];

        // Build adjacency list
        java.util.ArrayList<Integer>[] graph =
            new java.util.ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new java.util.ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int components = 0;

        // Count connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }

        // Need components - 1 operations
        return components - 1;
    }

    void dfs(int node,
             java.util.ArrayList<Integer>[] graph,
             boolean[] visited) {

        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}