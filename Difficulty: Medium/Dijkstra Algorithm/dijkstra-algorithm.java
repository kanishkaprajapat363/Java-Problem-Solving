class Pair{
    int node;
    int weight;

    Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Solution {

    public int[] dijkstra(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v,wt));

            
            adj.get(v).add(new Pair(u,wt));
        }

        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));

        pq.offer(new Pair(src,0));

        while(!pq.isEmpty()){

            Pair curr = pq.poll();

            int u = curr.node;
            int d = curr.weight;

            if(d > dist[u]) continue;

            for(Pair neigh : adj.get(u)){

                int v = neigh.node;
                int wt = neigh.weight;

                if(
                   dist[v] > dist[u] + wt){

                    dist[v] = dist[u] + wt;
                    pq.offer(new Pair(v,dist[v]));
                }
            }
        }

        return dist;
    }
}