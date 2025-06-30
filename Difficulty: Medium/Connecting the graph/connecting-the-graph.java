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
    public int Solve(int n, int[][] edge) {
        DisjointSet ds = new DisjointSet(n);
        int cnt=0;
        for(int[] arr : edge){
            int u = arr[0];
            int v = arr[1];
            if(ds.findPar(u)==ds.findPar(v)){
                cnt++;
                
            }
            else{
                ds.unionBySize(u,v);
            }
        }
        int cnc =0;
        for(int i=0;i<n;i++){
            if(ds.findPar(i)==i) cnc++;
            
        }
        int ans = cnc-1;
        if(cnt>=ans) return ans;
        return -1;
        
    }
}