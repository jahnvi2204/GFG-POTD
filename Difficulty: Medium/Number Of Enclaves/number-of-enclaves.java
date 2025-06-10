// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] mat) {
     
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
         int ans =0;
        for(int j=0;j<m;j++){
            //1
            if(!vis[0][j] && mat[0][j]==1){
                
                dfs(0,j,vis,mat,delrow,delcol);
            }
            //last
            if(!vis[n-1][j]&&mat[n-1][j]==1){
                
                dfs(n-1,j,vis,mat,delrow,delcol);
            }
            
        }   
        
        
        for(int j=0;j<n;j++){
            //1
            if(!vis[j][0]&&mat[j][0]==1){
                
                dfs(j,0,vis,mat,delrow,delcol);
            }
            //last
            if(!vis[j][m-1]&&mat[j][m-1]==1){
                dfs(j,m-1,vis,mat,delrow,delcol);
            }
        }

        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]&& mat[i][j]==1) ans++;
                
            }
        }
        return ans;
            
        
    }
    public static void dfs(int row , int col , boolean[][]vis,int[][] mat,int delrow[],int delcol[]){
        vis[row][col]=true;
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<4;i++){
            int nr = row+delrow[i];
            int nc = col +delcol[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&!vis[nr][nc]&&mat[nr][nc]==1){
                vis[nr][nc]=true;
                dfs(nr,nc,vis,mat,delrow,delcol);
                
            }
        }
    }
}