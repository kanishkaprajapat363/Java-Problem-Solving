class Solution {
    private int solve(int idx,int[] arr,int[] dp){
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        
        int pick=arr[idx]+solve(idx-2,arr,dp);
        int notpick=solve(idx-1,arr,dp);
        
        return dp[idx]=Math.max(pick,notpick);
    }
    public int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int[] dp=new int[n];
        
        Arrays.fill(dp,-1);
        return solve(n-1,arr,dp);
        
    }
}