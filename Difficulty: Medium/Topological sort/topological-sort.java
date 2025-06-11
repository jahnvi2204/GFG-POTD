class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]) dfs(i,vis,adj,st);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()) ans.add(st.pop());
        return ans;
        
    }
    public static void dfs(int src , boolean[] vis , List<List<Integer>> adj , Stack<Integer> st){
        vis[src]=true;
        for(int i : adj.get(src)){
            if(!vis[i])  dfs(i,vis,adj,st);
           
        }
        st.push(src);
        
    }
}