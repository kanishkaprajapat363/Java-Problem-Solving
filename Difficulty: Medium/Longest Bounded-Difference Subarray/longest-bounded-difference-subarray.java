class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n=arr.length;
        ArrayList<Integer> res=new ArrayList<>();
        Deque<Integer> maxDeque=new ArrayDeque<>();
        Deque<Integer> minDeque=new ArrayDeque<>();
        
        int i=0;
        int maxLen=0;
        int start=0;
        
        for(int j=0;j<n;j++){
            while(!maxDeque.isEmpty() && arr[j] > arr[maxDeque.peekLast()]){
                maxDeque.pollLast();
            }
            maxDeque.addLast(j);
            
            while(!minDeque.isEmpty() && arr[j]<arr[minDeque.peekLast()]){
                minDeque.pollLast();
            }
            minDeque.addLast(j);
            
            while(arr[maxDeque.peekFirst()]-arr[minDeque.peekFirst()]>x){
                if(maxDeque.peekFirst()==i) maxDeque.pollFirst();
                if(minDeque.peekFirst()==i) minDeque.pollFirst();
                i++;
            }
            if(j-i+1>maxLen){
                maxLen=j-i+1;
                start=i;
            }
        }
        for(int k=start;k<start+maxLen;k++){
            res.add(arr[k]);
        }
        return res;
    }
}