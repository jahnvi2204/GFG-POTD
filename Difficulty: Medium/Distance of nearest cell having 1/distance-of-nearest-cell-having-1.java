class Node{
    int first,second,third;
    Node(int first , int second , int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist  = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    vis[i][j]=true;
                    q.add(new Node(i,j,0));
                }
                else{
                    vis[i][j]=false;
                }
            }
        }
        int[] delrow = new int[]{-1,0,+1,0};
        int[] delcol = new int[]{0,-1,0,+1};
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int s = q.peek().third;
            q.remove();
            dist[r][c]=s;
            for(int i=0;i<4;i++){
                int nr = r+delrow[i];
                int nc = c+delcol[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m &&!vis[nr][nc]){
                vis[nr][nc]=true;
                q.add(new Node(nr,nc,s+1));
            }
            }
            
        }
        
        return dist;

    }
    
}