// User function Template for Java
 class Pair{
        int first;
        int second;
        public Pair(int first , int second){
            this.first = first;
            this.second = second;
        }
    }
class Solution {
   
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            
        }
        for(int [] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0) topoSort(i,adj,vis,st);
        }
        int [] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        while(!st.isEmpty()){
            int node = st.pop();
     for(int i =0 ;i<adj.get(node).size();i++ ){
      int v = adj.get(node).get(i).first;
      int wt = adj.get(node).get(i).second;
      if(dist[node] != Integer.MAX_VALUE && dist[node] + wt < dist[v]){
    dist[v] = dist[node] + wt;
}
    }
        }
        for(int i=0; i<V; i++){
    if(dist[i] == Integer.MAX_VALUE){
        dist[i] = -1;  
    }
}
        return dist;
        
    }
     public void  topoSort(int node, List<List<Pair>> adj,int[] vis ,Stack<Integer> st) {
        vis[node]=1;
        for(int i =0 ;i<adj.get(node).size();i++ ){
            int v = adj.get(node).get(i).first;
            if(vis[v]==0) topoSort(v,adj,vis,st);
           
        }
        st.push(node);
        
    
    }
}