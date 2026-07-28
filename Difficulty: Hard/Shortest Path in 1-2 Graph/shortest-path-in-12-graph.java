import java.util.*;

class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        List<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];

            if (d > dist[node]) continue;
            if (node == dest) return d;

            for (int[] nei : adj[node]) {
                int next = nei[0];
                int wt = nei[1];

                if (dist[next] > d + wt) {
                    dist[next] = d + wt;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return -1;
    }
}