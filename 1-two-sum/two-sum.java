class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<=n;i++){
            int complement=target-arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);
        }

        return new int[]{};
    }
}
