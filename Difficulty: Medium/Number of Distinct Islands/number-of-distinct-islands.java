class Solution {
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    
    public int countDistinctIslands(char[][] grid) {
        // code here
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] vis=new boolean[n][m];
        HashSet<ArrayList<String>> set=new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L' && !vis[i][j]){
                    ArrayList<String> shape=new ArrayList<>();
                    dfs(i,j,i,j,grid,vis,shape);
                    set.add(shape);
                }
            }
        }
        return set.size();
        
        
    }
    private void dfs(int r,int c, int baseR,int baseC,char[][] grid,boolean[][] vis,ArrayList<String> shape){
        vis[r][c]=true;
        shape.add((r-baseR)+","+(c-baseC));
        
        for(int k=0;k<4;k++){
            int nr=r+dr[k];
            int nc=c+dc[k];
            
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length &&
            grid[nr][nc]=='L' && !vis[nr][nc]){
                dfs(nr,nc,baseR,baseC,grid,vis,shape);
            }
        }
    }
}
