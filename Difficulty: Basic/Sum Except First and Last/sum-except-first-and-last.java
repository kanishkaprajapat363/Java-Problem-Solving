class Solution {
    int sumExceptFirstLast(int[] arr) {
        // your code here
        int sum=0;
        
        for(int i=1;i<arr.length-1;i++){
            sum+=arr[i];
        }
        
        return sum;
        
    }
}