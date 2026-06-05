class Solution {
    
    public boolean bfs(int s,ArrayList<Integer>[] adj,boolean[] vis){
        vis[s]=true;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{s,-1});
        
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int node=curr[0];
            int parent=curr[1];
        
        
            for(int i=0;i<adj[node].size();i++){
                int neigh=adj[node].get(i);
                if(!vis[neigh]){
                    vis[neigh]=true;
                    q.offer(new int[]{neigh,node});
                }else if(neigh!=parent){
                    return true;
                }
            }
        
            
        }
        return false;
        
        
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
               if (bfs(i,adj,vis)){
                    return true;
                    
                }
                
            }
        }
        return false;
    }
    
}