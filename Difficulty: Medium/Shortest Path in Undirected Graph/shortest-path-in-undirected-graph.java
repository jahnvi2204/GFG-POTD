class Solution {
    
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[src] = 0;
        q.add(src);
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int neighbor : adj.get(node)) {
                if(dist[neighbor] == Integer.MAX_VALUE) { 
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}