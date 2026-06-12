class Solution {
    
    int solve(int idx,int[] height,int[] dp){
        
        if(idx==0)return 0;
        
        if(dp[idx]!=-1)return dp[idx];
        
        int onejump=solve(idx-1,height,dp)+Math.abs(height[idx]-height[idx-1]);
        
        int twojump=Integer.MAX_VALUE;
        if(idx>1){
            twojump=solve(idx-2,height,dp)+Math.abs(height[idx]-height[idx-2]);
        }
        
        return dp[idx]=Math.min(onejump,twojump);
    }
    int minCost(int[] height) {
        // code here
        int n=height.length;
        
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        
        return solve(n-1,height,dp);
        
    }
}