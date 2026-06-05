class Solution {
    public String lexicographicallySmallest(String s, int k) {
        // code here
        int n=s.length();
        
        // check if power od 2 (bit manipulation)
        if((n & (n-1))==0){
            k=k/2;
        }else{
            k=k*2;
        }
        
        if(k>=n){
            return "-1";
        }
        
        //removing lexicographially (bigger char befroe small ones must be removed)
        StringBuilder stack=new StringBuilder();
        for(char ch:s.toCharArray()){
            while(stack.length()>0 && k>0 && stack.charAt(stack.length()-1)>ch){
                stack.deleteCharAt(stack.length()-1);
                k--;
            }
            stack.append(ch);
        }
        
        while(k>0){
            stack.deleteCharAt(stack.length()-1);
            k--;
        }
        
        if(stack.length()==0){
            return "-1";
        }
        
        return stack.toString();
    }
}