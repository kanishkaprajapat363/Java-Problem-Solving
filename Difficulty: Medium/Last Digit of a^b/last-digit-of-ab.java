class Solution {
    public int getLastDigit(String a, String b) {
        // code here
        if(b.equals("0"))return 1;
        
        int base=a.charAt(a.length()-1)-'0';
        
        int expMod4=0;
        
        for(char ch:b.toCharArray()){
            expMod4=(expMod4*10+(ch-'0'))%4;
        }
        
        if(expMod4==0)expMod4=4;
        
        int ans=1;
        for(int i=0;i<expMod4;i++){
            ans=(ans*base)%10;
        }
        
        return ans;
    }
};