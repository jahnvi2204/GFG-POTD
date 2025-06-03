// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int n=0;
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj,i,vis);
                n++;
                
            }
            
        }
        return n;
        
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj, int src , boolean[] vis){
        vis[src]=true;
        for(int i=0 ;i<adj.get(src).size();i++){
            if(adj.get(src).get(i)==1&&!vis[i]){
                dfs(adj,i,vis);
            }
            
        }
    }
};