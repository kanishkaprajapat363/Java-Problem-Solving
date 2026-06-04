class Solution {
    int maxSubstring(String s) {
        // code here
        int curr=0;
        int maxi=Integer.MIN_VALUE;
        
        for(int i=0;i<s.length();i++){
            int val=(s.charAt(i)=='0')?1:-1;
            
            curr=Math.max(val,curr+val);
            maxi=Math.max(maxi,curr);
        }
        
        return (maxi<=0)?-1:maxi;
        
    }
}