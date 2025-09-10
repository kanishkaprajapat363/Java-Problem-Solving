// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int minval=Integer.MAX_VALUE;
        int maxprofit=0;
        
        int n=prices.length;
        
        for(int i=0;i<n;i++){
            if(prices[i]<minval){
                minval=prices[i];
                
            }if(prices[i]-minval>maxprofit){
                maxprofit=prices[i]-minval;
            }
        }
        return maxprofit;
    }
}