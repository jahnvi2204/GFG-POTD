// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
         int [] vis = new int[V];
        int [] pathvis = new int[V];
        int [] check = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                check(i,pathvis,vis,check,adj);
            }
        }
        List<Integer> safe = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1) safe.add(i);
        }
        // Collections.sort(safe);
        return safe;


        
    }
    public boolean check(int src , int[] pathvis ,int[] vis ,int[] check , List<List<Integer>> adj ){
            vis[src]=1;
            pathvis[src]=1;
            check[src]=0;
            for(int i : adj.get(src)){
                if(vis[i]==0){
                    if(check(i,pathvis,vis,check,adj)) return true;
                }
                else if(pathvis[i]==1){
                    return true;
                }
            }
            pathvis[src]=0;
            check[src]=1;
            return false;
}
}
