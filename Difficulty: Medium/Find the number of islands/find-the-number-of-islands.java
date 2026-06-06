class Solution {
    
    public void dfs(char[][] grid,int r, int c){
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        
        int rows=grid.length;
        int cols=grid[0].length;
        
        if(r<0 || c<0 ||r>=rows|| c>=cols|| grid[r][c]=='W'){
            return;
        }
        
        grid[r][c]='W';
        
        for(int dir=0;dir<8;dir++){
            int nrows=r+dx[dir];
            int ncols=c+dy[dir];
            
            dfs(grid,nrows,ncols);
        }
    }
    public int countIslands(char[][] grid) {
        // Code here
        int rows=grid.length;
        int cols=grid[0].length;
        
        int count=0;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='L'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        
        return count;
    }
}