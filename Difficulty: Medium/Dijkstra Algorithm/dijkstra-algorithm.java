class Solution {
   class Pair{
        int f ;
        int s;
        Pair(int f, int s){
            this.f=f;
            this.s=s;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.f-y.f);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[2],edge[1]));
            adj.get(edge[1]).add(new Pair(edge[2],edge[0]));
            
        }
        
        int[] dist= new int[V];
        for(int i =0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        pq.add(new Pair(0,src));
        while(!pq.isEmpty()){
            int dis = pq.peek().f;
            int node = pq.peek().s;
            pq.remove();
            for(int i=0;i<adj.get(node).size();i++){
                int edwt = adj.get(node).get(i).f;
                int adnd = adj.get(node).get(i).s;
                if(dis + edwt < dist[adnd]){
                    dist[adnd]=dis+edwt;
                    pq.add(new Pair(dist[adnd],adnd));
                }
                
            }
        }
        return dist;
    }
}