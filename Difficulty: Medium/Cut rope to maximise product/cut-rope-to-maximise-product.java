class Solution {
    public int maxProduct(int n) {
        // code here
        int[] dp=new int[n+1];
        dp[1]=1;
        
        for(int len=2;len<=n;len++){
            for(int cut=1;cut<len;cut++){
                int left=Math.max(cut,dp[cut]);
                int right=Math.max(len-cut,dp[len-cut]);
                dp[len]=Math.max(dp[len],left*right);
            }
        }
        
        return dp[n];
        
    }
}