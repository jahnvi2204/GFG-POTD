class Solution {
    int missingNum(int arr[]) {
        // code here
        Arrays.sort(arr);
        if(arr[0]!=1) return 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
            
        }
        return arr.length+1;
        
        
    }
}