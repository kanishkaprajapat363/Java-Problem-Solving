class Solution {
    
    public void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(int i=0;i<adj.get(node).size();i++){
            int neigh=adj.get(node).get(i);
            if(!vis[neigh]){
                dfs(neigh,vis,adj);
            }
        }
    }
    
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.size();i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int count=0;
        boolean[] vis=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                count++;
            }
        }
        
        return count;
        
        
    }
}