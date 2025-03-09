//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.countPS(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countPS(String s) {
        // code here 
        int n = s.length();
        int count = 0;
        int l,r = 0;
        for(int i = 0;i<n;i++)
        {
            //odd Length Palindrome
            l = i-1;
            r = i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r))
            {
                count++;
                l--;
                r++;
            }
            //Even Length Palindrome
            l = i-1;
            r = i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r))
            {
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}