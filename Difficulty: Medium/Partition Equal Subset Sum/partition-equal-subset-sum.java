class Solution {
    static boolean equalPartition(int arr[]) {
        //memoization
        
        int total=0;
        for(int x:arr)total+=x;
        
        if((total&1)==1)return false;
        
        int target=total/2;
        int n=arr.length;
        
        int[][] dp=new int[n][target+1];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(n-1,target,arr,dp);
        
    }
    
    static boolean solve(int idx,int target,int[] arr,int[][] dp){
        if(target==0)return true;
        
        if(idx==0)return arr[0]==target;
        
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }
        
        boolean nottake=solve(idx-1,target,arr,dp);
        
        boolean take=false;
        
        if(arr[idx]<=target){
            take=solve(idx-1,target-arr[idx],arr,dp);
        }
        dp[idx][target]=(take||nottake)?1:0;
        
        return take||nottake;
    }
}