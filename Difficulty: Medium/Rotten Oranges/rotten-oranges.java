class Solution {
    public int orangesRot(int[][] mat) {
        // code here
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        
        int rows=mat.length;
        int cols=mat[0].length;
        
        Queue<int[]> q=new LinkedList<>();
        int freshcount=0;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(mat[i][j]==1){
                    freshcount++;
                }
            }
        }
        
        int time=0;
        
        while(!q.isEmpty() && freshcount>0){
            int size=q.size();
            
            time++;
            
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];
                
                for(int dir=0;dir<4;dir++){
                    int nrow=r+dx[dir];
                    int ncol=c+dy[dir];
                    
                    if(nrow>=0 && ncol>=0 && nrow<rows && ncol<cols && mat[nrow][ncol]==1){
                        mat[nrow][ncol]=2;
                        freshcount--;
                        q.offer(new int[]{nrow,ncol});
                    }
                }
            }
        }
        return freshcount==0?time:-1;
        
    }
}