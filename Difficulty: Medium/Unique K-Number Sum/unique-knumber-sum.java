class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),n,k,1);
        return result;
    }
    
    private void backtrack(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> temp,int n,int k,int start){
        if(n==0 && temp.size()==k){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        if(n<0 || temp.size()>k){
            return;
        }
        
        for(int i=start;i<=9;i++){
            temp.add(i);
            backtrack(result,temp,n-i,k,i+1);
            temp.remove(temp.size()-1);
        }
    }
}