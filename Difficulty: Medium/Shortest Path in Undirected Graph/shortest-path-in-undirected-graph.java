class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int dist[]=new int[V];
        Arrays.fill(dist,-1);
        
        Queue<Integer> q=new LinkedList<>();
        
        dist[src]=0;
        q.offer(src);
        
        while(!q.isEmpty()){
            int node=q.poll();
            
            for(int neigh:adj.get(node)){
                if(dist[neigh]==-1){
                    dist[neigh]=dist[node]+1;
                    q.offer(neigh);
                }
            }
        }
        return dist;
    }
}
