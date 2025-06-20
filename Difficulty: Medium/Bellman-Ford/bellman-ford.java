// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        for(int i=0;i<V;i++) dist[i]=(int)(1e8);
        dist[src]=0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if(dist[u]!=1e8 && dist[u]+wt<dist[v]){
                dist[v]=dist[u]+wt;
            }
        }
        
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if(dist[u]!=1e8 && dist[u]+wt<dist[v]){
                int temp[] = new int[1];
                temp[0]=-1;
                return temp;
            }
        }
       return dist;
    }
}
