class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        
        if(n>10) return ans;
        if(n==1){
            for(int i=0;i<=9;i++){
                ans.add(i);
            }
            return ans;
        }
        
        generate(ans,n,0,1);
        return ans;
        
    }
    
    static void generate(ArrayList<Integer> ans,int n,int num, int start){
        if(n==0){
            ans.add(num);
            return;
        }
        
        for(int d=start;d<=9;d++){
            generate(ans,n-1,num*10+d,d+1);
        }
    }
}
