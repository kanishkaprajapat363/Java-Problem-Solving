class Solution {
    public String removeKdig(String s, int k) {
        // code here
        StringBuilder st=new StringBuilder();
        for(char ch:s.toCharArray()){
            while(k>0 && st.length()>0 && st.charAt(st.length()-1)>ch){
                st.deleteCharAt(st.length()-1);
                k--;
                
            }
            st.append(ch);
        }
        
        while(k>0 &&st.length()>0){
            st.deleteCharAt(st.length()-1);
            k--;
        }
        
        int i=0;
        while(i<st.length() && st.charAt(i)=='0'){
            i++;
        }
        
        String ans=st.substring(i);
        return ans.length()==0 ?"0":ans;
        
    }
}