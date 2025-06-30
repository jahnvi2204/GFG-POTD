class DisjointSet {
    List<Integer> parent, size;
    
    public DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findPar(int node) {
        if(node == parent.get(node)) {
            return node;
        }
        int ulp = findPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if(ulp_u == ulp_v) return;
        
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<V;i++){
            for(int[] edge : adj.get(i)){
                int v = edge[0];
                int wt = edge[1];
                if(i<v){
                    edges.add(new int[]{i,v,wt});
                }
            }
        }
        Collections.sort(edges,(a,b)->a[2]-b[2]);
        DisjointSet ds = new DisjointSet(V);
        int mst=0;
        for(int[] edge : edges){
            int wt = edge[2];
            int u= edge[0];
             int v = edge[1];
             if(ds.findPar(u)!=ds.findPar(v)){
                 mst+=wt;
                 ds.unionBySize(u,v);
             }

        }
        return mst;
        
        
       
    }
}