class Solution {
    int solve(int i,int j, int[][] mat, int[][] dp){
        //memoization
        int n=mat.length;
        if(j<0 || j>=n) return (int) 1e9;
        if(i==0) return mat[i][j];
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];

        int up=mat[i][j]+solve(i-1,j,mat,dp);
        int ld=mat[i][j]+solve(i-1,j-1,mat,dp);
        int rd=mat[i][j]+solve(i-1,j+1,mat,dp);

        return dp[i][j]=Math.min(up,Math.min(ld,rd));
    }

    public int minFallingPathSum(int[][] mat) {
        //memoization
        int n=mat.length;
        int[][] dp=new int[n][n];

        for (int[] row : dp)
            java.util.Arrays.fill(row, Integer.MIN_VALUE);
        int ans=Integer.MAX_VALUE;

        for(int j=0;j<n;j++){
            ans=Math.min(ans,solve(n-1,j,mat,dp));
        }

        return ans;
        
    }
}