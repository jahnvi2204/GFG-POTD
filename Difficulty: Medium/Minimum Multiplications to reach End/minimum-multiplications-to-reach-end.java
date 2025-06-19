// User function Template for Java

class Solution {
     class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
           if (start == end) return 0;
           int[] dist = new int[100000];
           Arrays.fill(dist,Integer.MAX_VALUE);
           dist[start]=0;
           Queue<Pair> q = new LinkedList<>();
           q.add(new Pair(start,0));
           while(!q.isEmpty()){
               int num = q.peek().node;
               int steps =q.peek().distance;
               q.remove();
               for(int i : arr){
                   int n = (num*i)%100000 ;
                   if(n==end) return steps+1;
                   if(steps+1<dist[n]){
                       dist[n]=steps+1;
                       q.add(new Pair(n,steps+1));
                   }
               }
           }
           return -1;
    }
}
