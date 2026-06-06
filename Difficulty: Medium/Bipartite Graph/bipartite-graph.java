class Solution {
    
    public boolean dfs(int node,int currcolor,ArrayList<ArrayList<Integer>> adj,int[] color){
        color[node]=currcolor;
        
        for(int i=0;i<adj.get(node).size();i++){
            int neigh=adj.get(node).get(i);
            if(color[neigh]==-1){
                if(!dfs(neigh,1-currcolor,adj,color)){
                    return false;
                }
            }else if(color[neigh]==color[node]){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
            
        }
        
        int[] color=new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!dfs(i,0,adj,color)){
                    return false;
                }
            }
        }
        return true;
        
    }
}