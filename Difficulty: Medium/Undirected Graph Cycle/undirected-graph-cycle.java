class Solution {
    public boolean isCycle(int V, int[][] edges) {
    
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[]vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,-1,adj,vis)) return true;
                
            }
        }
        return false;
    
        
    }
    public boolean dfs(int src , int parent ,ArrayList<ArrayList<Integer>> adj , boolean[]vis){
        vis[src]=true;
        for(int node : adj.get(src)){
            if(!vis[node]){
                if(dfs(node,src,adj,vis)) return true;
                
            }
            else if(node!=parent) return true;
        }
        return false;
    }
    
    
}