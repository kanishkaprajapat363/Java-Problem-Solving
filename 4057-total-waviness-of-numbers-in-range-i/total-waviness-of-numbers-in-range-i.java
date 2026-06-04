class Solution {
    public int totalWaviness(int num1, int num2) {

        int total=0;
        for(int i=num1;i<=num2;i++){
            total+=waviness(i);
        }

        return total;
        
    }

    public int waviness(int num){
        int count=0;
        String s=String.valueOf(num);

        if(s.length()<3){
            return 0;
        }

        for(int j=1;j<s.length()-1;j++){
            char prev=s.charAt(j-1);
            char curr=s.charAt(j);
            char next=s.charAt(j+1);

            if((curr>prev && curr>next)||(curr<prev && curr<next)){
                count++;
            }
            
        
        }

        return count;

       
    }
}