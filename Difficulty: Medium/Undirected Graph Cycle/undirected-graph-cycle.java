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
        int m = edges.length;
        boolean[]vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(detect(i,V,adj,vis)) return true;
                
            }
        }
        return false;
    
        
    }
    public boolean detect(int src ,int V,ArrayList<ArrayList<Integer>> adj , boolean[]vis){
        vis[src]=true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,-1});
        while(!q.isEmpty()){
            int[] nodePair = q.poll();  
            int first = nodePair[0];
            int second = nodePair[1]; 
           
            for(int adjnode : adj.get(first)){
                if(!vis[adjnode]){
                    vis[adjnode]=true;
                    q.add(new int[]{adjnode,first});
                }
                else if(adjnode!=second) return true;
            }
        }
        return false;
    }
    
}