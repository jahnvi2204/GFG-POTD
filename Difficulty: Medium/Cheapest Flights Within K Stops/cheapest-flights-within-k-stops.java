class Solution {
     static class Tuple{
        int f;
        int s;
        int t;
        Tuple(int f ,int s , int t){
            this.f=f;
            this.s=s;
            this.t=t;
        }
    }
     static class Pair{
        int f;
        int s;
        Pair(int f ,int s ){
            this.f=f;
            this.s=s;
        }
    }

    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       for(int i=0;i<n;i++){
           adj.add(new ArrayList<>());
       }
       for(int[] arr : flights){
           adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
       }
       int[] price = new int[n];
       for(int i=0;i<n;i++) price[i]=(int)(1e9);
       price[src]=0;
       Queue<Tuple> q = new LinkedList<>();
       // stops,src,dist;
       q.add(new Tuple(0,src,0));
       while(!q.isEmpty()){
           Tuple t = q.poll();
           int stops = t.f;
           int node = t.s;
           int cost = t.t;
           if(stops>k) continue;
           for(Pair p : adj.get(node)){
               int adjNode = p.f;
               int wt = p.s;
               if(cost+wt<price[adjNode]){
                   price[adjNode] = cost+wt;
                   q.add(new Tuple(stops+1,adjNode,cost+wt));
               }
               
           }
           
       }
       if(price[dst]==(int)(1e9)) return -1;
       return price[dst];
       
        
    }
}