class Solution {
    public int minimumCost(int[] cost, int w) {
        // code here
        int INF=Integer.MAX_VALUE/2;
        
        int[] dp=new int[w+1];
        for(int i=1;i<=w;i++){
            dp[i]=INF;
        }
        dp[0]=0;
        for(int j=0;j<cost.length;j++){
            if(cost[j]==-1) continue;
            
            int weight=j+1;
            
            for(int i=weight;i<=w;i++){
                dp[i]=Math.min(dp[i],dp[i-weight]+cost[j]);
            }
        }
        
        return dp[w]==INF?-1:dp[w];
        
    }
}