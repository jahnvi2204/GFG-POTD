

class Solution {
    class Pair {
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
    
    public int countIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m  = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt =0;
        for(int ro=0;ro<n;ro++){
            for(int co =0;co<m;co++){
                if(vis[ro][co]==0&&grid[ro][co]=='L'){
                    cnt++;
                    bfs(ro,co,vis,grid);
                }
            }
        }
        return cnt;
    }
    private void bfs(int ro , int co, int[][] vis, char[][]grid){
        vis[ro][co]=1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int n = grid.length;
        int m  = grid[0].length;
        
        while(!q.isEmpty()){
        int row = q.peek().first;
        int col = q.peek().second;
        q.remove();
        
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int k = i+row;
                int l =j+col;
                if(k>=0 && k<n && l>=0 && l<m && vis[k][l]==0 &&grid[k][l]=='L' ){
                    vis[k][l]=1;
                    q.add(new Pair(k,l));
                    
                }
            }
        }
    }
    
}}