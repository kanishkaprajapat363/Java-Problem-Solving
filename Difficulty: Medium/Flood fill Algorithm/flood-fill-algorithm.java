class Solution {
    public void dfs(int[][] image, int sr, int sc, int oldcolor,int newcolor){
        int rows=image.length;
        int cols=image[0].length;
        
        if(sr<0|| sc<0|| sr>=rows|| sc>=cols|| image[sr][sc]!=oldcolor){
            return; 
        }
        
        image[sr][sc]=newcolor;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for(int dir=0;dir<4;dir++){
            int nrow=sr+dx[dir];
            int ncol=sc+dy[dir];
            
            dfs(image,nrow,ncol,oldcolor,newcolor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldcolor=image[sr][sc];
        if(oldcolor==newColor){
            return image;
        }
        
        dfs(image,sr,sc,oldcolor,newColor);
        return image;
    }
}