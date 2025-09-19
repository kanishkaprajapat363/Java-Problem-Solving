class Solution {
    public int minParentheses(String s) {
        
        int open=0;
        int add=0;
        
        for(char ch:s.toCharArray()){
            if(ch=='('){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    add++;
                }
            }
        }
        return open+add;
        // code here
        
    }
}
