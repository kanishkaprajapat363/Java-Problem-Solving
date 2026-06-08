class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        //PRIM'S ALGORITHM
        
        //it growns the mst vertex by vertex
       // Start from any node.
        //Add the minimum-weight edge that connects the current tree to an unvisited node.
        //Repeat until all vertices are included.
        
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        
        //minheap : {wt,node}
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        boolean[] vis=new boolean[V];
        
        pq.offer(new int[]{0,0}); //{initial wt, starting node}
        int mstwt=0;
        
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int wt=curr[0];
            int node=curr[1];
            
            if(vis[node]) continue;
            
            vis[node]=true;
            mstwt+=wt;
            
            for(int i=0;i<adj.get(node).size();i++){
                int[] neigh=adj.get(node).get(i);
                int adjnode=neigh[0];
                int adjwt=neigh[1];
                
                if(!vis[adjnode]){
                    pq.offer(new int[]{adjwt,adjnode});
                }
            }
        }
        return mstwt;
        
    }
}
