class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int [] vis = new int[V];
        int [] pathvis = new int[V];


        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            
        }
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,pathvis,vis,adj)) return true;
            }
        }
        
        return false;
        
        
    }
    public boolean dfs(int src , int[] pathvis ,int[] vis , ArrayList<ArrayList<Integer>> adj ){
            vis[src]=1;
            pathvis[src]=1;
            for(int i : adj.get(src)){
                if(vis[i]==0){
                    if(dfs(i,pathvis,vis,adj)) return true;
                }
                else if(pathvis[i]==1){
                    return true;
                }
            }
            pathvis[src]=0;
            return false;
}
}