class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // memoization
        int n=arr.length;
        int[][] dp=new int[n][sum+1];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
            
        }
        
        return solve(n-1,sum,arr,dp);
        
    }
    
    static boolean solve(int idx,int target,int[] arr,int[][] dp){
        if(target==0) return true;
        
        if(idx==0)return arr[0]==target;
        
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }
        
        boolean nottake=solve(idx-1,target,arr,dp);
        
        boolean take=false;
        if(target>=arr[idx]){
            take=solve(idx-1,target-arr[idx],arr,dp);
            
        }
        
        dp[idx][target]=(take||nottake)?1:0;
        
        return take||nottake;
    }
}