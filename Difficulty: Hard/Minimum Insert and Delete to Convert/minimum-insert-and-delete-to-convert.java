class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        // code here
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i=0;i<b.length;i++){
            map.put(b[i],i);
        }
        
        ArrayList<Integer> lis=new ArrayList<>();
        
        for(int x:a){
            if(!map.containsKey(x)) continue;
            
            int idx=map.get(x);
            
            int pos=Collections.binarySearch(lis,idx);
            if(pos<0) pos=-pos-1;
            if(pos==lis.size()){
                lis.add(idx);
            }else{
                lis.set(pos,idx);
            }
        }
        int lcs=lis.size();
        return a.length+b.length-2*lcs;
        
    }
}