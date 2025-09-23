class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        if(s1.length()!=s2.length()){
            return false;
        }
        
        int[] map1=new int[256];
        int[] map2=new int[256];
        
        java.util.Arrays.fill(map1,-1);
        java.util.Arrays.fill(map2,-1);
        
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            
            if(map1[c1]==-1){
                if(map2[c2]!=-1){
                    return false;
                }
                map1[c1]=c2;
                map2[c2]=c1;
            }else{
                if(map1[c1]!=c2){
                    return false;
                }
            }
        }
        return true;
        
    }
}