class Solution {
    
    public void dfs(int node, Stack<Integer> s, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        
        for(int i=0;i<adj.get(node).size();i++){
            int neigh=adj.get(node).get(i);
            if(!vis[neigh]){
                dfs(neigh,s,vis,adj);
            }
        }
        s.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            adj.get(u).add(v);
        }
        
        boolean[] vis=new boolean[V];
        Stack<Integer> s=new Stack<>();
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,s,vis,adj);
            }
        }
        
        
        ArrayList<Integer> topo=new ArrayList<>();
        
        while(!s.isEmpty()){
            topo.add(s.pop());
        }
        
        return topo;
        
    }
}