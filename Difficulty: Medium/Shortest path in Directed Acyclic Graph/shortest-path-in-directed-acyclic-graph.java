// User function Template for Java
class Solution {
    public void dfs(int node,Stack<Integer> s,boolean[] vis, ArrayList<ArrayList<int[]>> adj){
        vis[node]=true;
        
        for(int i=0;i<adj.get(node).size();i++){
            int[] neigh=adj.get(node).get(i);
            int v=neigh[0];
            if(!vis[v]){
                dfs(v,s,vis,adj);
            }
        }
        s.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            
            adj.get(u).add(new int[]{v,wt});
        }
        
        Stack<Integer> s=new Stack<>();
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,s,vis,adj);
            }
        }
        
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        
        while(!s.isEmpty()){
            int u=s.pop();
            if(dist[u]!=Integer.MAX_VALUE){
                for(int i=0;i<adj.get(u).size();i++){
                    int v=adj.get(u).get(i)[0];
                    int wt=adj.get(u).get(i)[1];
                    if(dist[v]>dist[u]+wt){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        }
        
        return dist;
        
        
        
    }
}