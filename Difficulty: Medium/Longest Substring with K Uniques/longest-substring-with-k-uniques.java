class Solution {
    public int longestKSubstr(String s, int k) {
        int n=s.length();
        Map<Character,Integer> freq=new HashMap<>();
        int left=0;
        int maxlen=-1;
        
        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            freq.put(c,freq.getOrDefault(c,0)+1);
            
            while(freq.size()>k){
                char leftChar=s.charAt(left);
                freq.put(leftChar,freq.get(leftChar)-1);
                
                if(freq.get(leftChar)==0){
                    freq.remove(leftChar);
                }
                left++;
            }
            if(freq.size()==k){
                maxlen=Math.max(maxlen,right-left+1);
            }
        }
        return maxlen;
        // code here
        
    }
}