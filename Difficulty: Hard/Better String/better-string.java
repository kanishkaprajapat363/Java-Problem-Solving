class Solution {
    static long countDistinct(String s){
        int n=s.length();
        long[] dp=new long[n+1];
        dp[0]=1;
        
        HashMap<Character,Integer> last=new HashMap<>();
        
        for(int i=1;i<=n;i++){
            char ch=s.charAt(i-1);
            dp[i]=2*dp[i-1];
            
            if(last.containsKey(ch)){
                dp[i]-=dp[last.get(ch)-1];
            }
            
            last.put(ch,i);
        }
        return dp[n];
    }
    
    public static String betterString(String s1, String s2) {
        // Code here
        long c1=countDistinct(s1);
        long c2=countDistinct(s2);
        
        return c1>=c2?s1:s2;
        
        
    }
}