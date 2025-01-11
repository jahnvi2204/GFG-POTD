//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        
  java.util.Set<Character> set = new java.util.HashSet<>();  
        int l=0;
        int r=0;
        int maxLength=0;
        while(r<s.length()){
         
            while(set.contains(s.charAt(r))&&l<r){
                set.remove(s.charAt(l));
                l++;
            }
         
            set.add(s.charAt(r));
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}