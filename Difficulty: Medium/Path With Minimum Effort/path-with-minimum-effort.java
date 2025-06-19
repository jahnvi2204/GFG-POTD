
class Solution {
   static class Pair{
        int f;
        int s;
        int t;
        Pair(int f ,int s , int t){
            this.f=f;
            this.s=s;
            this.t=t;
        }
    }
    public static int MinimumEffort(int rows, int columns, int[][] grid) {
         int n = grid.length;
         int m = grid[0].length;
         int[][] dist = new int[n][m];
         for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 dist[i][j]=Integer.MAX_VALUE;
             }
         }
         dist[0][0]=0;
        int[] row = {-1,0,+1,0};
        int[] col = {0,1,0,-1};
         PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)-> x.f-y.f);
         pq.add(new Pair(0,0,0));
         while(!pq.isEmpty()){
              Pair p = pq.peek();
              pq.remove();
              int diff = p.f;
              int r=p.s;
              int c = p.t;
              if(r==n-1&&c==m-1) return diff;
              for( int i=0;i<4;i++){
                int nr = row[i]+r;
                int nc = col[i]+c;
                if(nr>=0&&nr<n&&nc>=0&&nc<m){
                    int eff = Math.max(Math.abs(grid[nr][nc]-grid[r][c]),diff);
                    if(eff<dist[nr][nc]){
                        dist[nr][nc]=eff;
                        pq.add(new Pair(eff,nr,nc));
                    }

                }
              }      
         }
         return 0;
         
        
    }
}


