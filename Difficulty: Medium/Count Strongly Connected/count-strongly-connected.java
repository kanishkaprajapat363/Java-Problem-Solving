class Solution {
    public void dfs1(int node, Stack<Integer> s, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(int i=0;i<adj.get(node).size();i++){
            int neigh=adj.get(node).get(i);
            if(!vis[neigh]){
                dfs1(neigh,s,vis,adj);
            }
        }
        s.push(node);
    }
    
    public void dfs2(int node, boolean[] vis, ArrayList<ArrayList<Integer>> revadj){
        vis[node]=true;
        for(int i=0;i<revadj.get(node).size();i++){
            int neigh=revadj.get(node).get(i);
            if(!vis[neigh]){
                dfs2(neigh,vis,revadj);
            }
        }
    }
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<ArrayList<Integer>> revadj=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            revadj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            adj.get(u).add(v);
            revadj.get(v).add(u);
        }
        
        boolean[] vis=new boolean[V];
        Stack<Integer>  s=new Stack<>();
        
        //dfs to sort the edges 
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs1(i,s,vis,adj);
            }
        }
        
        //dfs on transpose graph
        Arrays.fill(vis,false);
        int count=0;
        
        while(!s.isEmpty()){
            int curr=s.pop();
            
            if(!vis[curr]){
                dfs2(curr,vis,revadj);
                count++;
            }
        }
        
        return count;
        
        
        
    }
}