class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int  i : arr ){
            sum+=i;
            max= Math.max(max,i);
        }
        int left = 1;
        int result=max;
        while(left<=max){
            int mid = left+(max-left)/2;
            long hours =0;
            for(int i : arr){
               hours += (i + mid - 1) / mid;   
               }
            if(hours<=k){
                result = mid;
                max= mid-1;
                
            }
            else {
                
                    left = mid+1;
                }
            
            
            
            }
            
            return result;
        
    }
}
