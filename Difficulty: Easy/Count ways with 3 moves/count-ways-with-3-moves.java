class Solution {

    static int countWays(int n) {
        // add your code here
        if(n==1) return 1;
        if(n==2) return 2;
        
        int a=1;
        int b=1;
        int c=2;
        
        for(int i=3;i<=n;i++){
            int d=a+b+c;
            a=b;
            b=c;
            c=d;
            
        }
        return c;
    }
}
