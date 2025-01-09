//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int s) {
        int n=arr.length;
        int l = 0;
        int r = 0;
        int sum = 0;

        ArrayList<Integer> res = new ArrayList<>();
        while(r < n){
            sum += arr[r];
            while(sum > s && l<n){ 
                sum -= arr[l];
                l++;
            }
            if(sum == s && r>=l ){
                res.add(l + 1);
                res.add(r + 1); 
               break;
            }
            r++;
        }
        if(res.size() == 0 || l> r){
            res.clear();
            res.add(-1);
    }  
    return res;
}
}
        // code here
    
