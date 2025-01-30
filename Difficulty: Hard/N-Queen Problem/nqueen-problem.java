//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
   static ArrayList<ArrayList<Integer>> nQueen(int n) 
   {
       // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[][] arr = new int[n][n];
        nQueens(arr,0,result,n);  
        return result;
   }
   static void nQueens(int[][] arr,int row,ArrayList<ArrayList<Integer>> result,int n)
   {
       if(row==arr.length)
       {
           ArrayList<Integer> answer = new ArrayList<>();
           for(int i=0;i<arr.length;i++)
           {
               for(int j=0;j<arr.length;j++)
               {
                   if(arr[i][j]==1)
                   answer.add(j+1);
               }
           }
           result.add(answer);
          arr = new int[n][n];
          return;
       }
       
       for(int col=0;col<n;col++)
       {
           if(isSafe(arr,row,col))
           {
               arr[row][col] = 1;
               nQueens(arr,row+1,result,n);
               arr[row][col] = 0;
           }
       }
   }
   public static boolean isSafe(int[][] arr,int row,int col)
   {
       for(int i = row-1 ; i>=0 ; i--)
         {
             if(arr[i][col]==1)
             return false;
         }
        for(int i=row-1,j=col-1;i>=0 && j>=0 ; j--,i--)
       {
             if(arr[i][j]==1)
             return false;
       }
         for(int i=row-1,j=col+1;i>=0 && j<arr[0].length ; j++,i--)
       {
             if(arr[i][j]==1)
             return false;
       }
       return true;
   }
}