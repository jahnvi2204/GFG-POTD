//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


import java.util.HashMap;

class Solution {
    int countPairs(int arr[], int target) {
           Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        
        for(int i=0;i<arr.length;i++){
            int count=0;
            
            if(!map.isEmpty()){
                if(map.get(arr[i])!=null)
                    count=map.get(arr[i]);
                int anotherEle=target-arr[i];    
                
                if(map.get(anotherEle)!=null)
                    ans+=(map.get(anotherEle));
                
            }
            map.put(arr[i],count+1);
        }
        
        return ans;
    }
}



//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends