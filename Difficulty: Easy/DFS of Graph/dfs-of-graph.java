class Solution {
    public void dfsrec(int s, boolean vis[], ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj){
        vis[s]=true;
        
        res.add(s);
        
        for(int i=0;i<adj.get(s).size();i++){
            if(!vis[adj.get(s).get(i)]){
                dfsrec(adj.get(s).get(i),vis,res,adj);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v=adj.size();
        boolean vis[]=new boolean[v];
        ArrayList<Integer> res=new ArrayList<>();
        
        dfsrec(0,vis,res,adj);
        return res;
    }
}