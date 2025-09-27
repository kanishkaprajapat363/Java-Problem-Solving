class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        int n=arr.length;
        boolean[] isFlipped=new boolean[n];
        int flipCount=0,res=0;
        
        for(int i=0;i<n;i++){
            if(i>=k && isFlipped[i-k]){
                flipCount--;
            }
            
            if((arr[i]+flipCount)%2==0){
                if(i+k>n) return -1;
                
                isFlipped[i]=true;
                flipCount++;
                res++;
            }
        }
        return res;
        
        
    }
}
