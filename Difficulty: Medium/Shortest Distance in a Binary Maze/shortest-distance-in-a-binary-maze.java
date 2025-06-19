// User function Template for Java

class Solution {
    class Pair{
        int f;
        int s;
        int t;
        Pair(int f ,int s , int t){
            this.f=f;
            this.s=s;
            this.t=t;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
         if(source[0]==destination[0]&&source[1]==destination[1]){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] dis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            dis[i][j]=Integer.MAX_VALUE;
         }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,source[0],source[1]));
        int[] row = {-1,0,+1,0};
        int[] col = {0,1,0,-1};
        while(!q.isEmpty()){
            int dist = q.peek().f;
            int r = q.peek().s;
            int c = q.peek().t;
            q.remove();
            if(r == destination[0]&&c == destination[1]) return dist;
            for( int i=0;i<4;i++){
                int nr = row[i]+r;
                int nc = col[i]+c;
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1&&dist+1<dis[nr][nc]){
                dis[nr][nc]=dist+1;
                 if(nr == destination[0]&&nc == destination[1]) return dist+1;
                    q.add(new Pair(dist+1,nr,nc));
                }
            }
            
        }
       return -1;
        
    }
}
