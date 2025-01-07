//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

import java.util.HashMap;

class Solution {

    int countPairs(int arr[], int target) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int count = 0;
        int n = arr.length; 

        for (int i = 0; i < n; i++) {
            int temp = target - arr[i];

            
            if (res.containsKey(temp)) {
                count += res.get(temp); 
            }

            res.put(arr[i], res.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}



//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends