// User function Template for Java

class Solution {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int max = 100000;
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=100000;
            }
            
        }
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
             dist[u][v]= wt;
             dist[v][u]=wt;
        
            
        }
        for(int j=0;j<n;j++){
                dist[j][j]=0;
         }
         for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==max || dist[k][j]==max) continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int cntCity=n;
        int cityNo=-1;
        for(int city=0;city<n;city++){
            int cnt =0;
            for(int adj =0;adj<n;adj++){
                if(city != adj&&dist[city][adj]<=distanceThreshold){
                    cnt++;
                }
               
            }
             if(cnt<=cntCity||(cnt==cntCity&&city>cityNo)){
                    cntCity = cnt;
                    cityNo = city;
                }
        }
        return cityNo;
        
        
    }
}
