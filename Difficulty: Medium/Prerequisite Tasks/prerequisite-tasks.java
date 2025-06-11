// User function Template for Java

class Solution {
    public boolean isPossible(int N, int P, int[][] edges) {
        // Your Code goes here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge :edges ){
            adj.get(edge[0]).add(edge[1]);
        }
        int[] ind = new int[N];
        for(int i=0;i<N;i++){
            for(int it : adj.get(i)){
                ind[it]++;
            }
        }
         Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            if(ind[i]==0) q.add(i);
        }
        int cnt=0;
        while(!q.isEmpty()){
            int n = q.remove();
            cnt++;
            for(int i : adj.get(n)){
                ind[i]--;
                if(ind[i]==0) q.add(i);
                
            }
        }
        return cnt==N;
        
        
    }
}