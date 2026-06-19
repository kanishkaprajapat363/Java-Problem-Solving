class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        // code here
        int n=arr.length;
        
        long[] pref=new long[n];
        pref[0]=arr[0];
        
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+arr[i];
        }
        
        ArrayList<Integer> ans =new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int m=i/2;
            
            long leftSum=(m>0)?pref[m-1]:0;
            long leftCost=1L*arr[m]*m-leftSum;
            
            long rightSum=pref[i]-pref[m];
            long rightCost=rightSum-1L*arr[m]*(i-m);
            
            long cost=leftCost+rightCost;
            ans.add((int) cost);
        }
        
        return ans;
        
    }
}