//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
              Stack<Integer>s=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[i].equals("+")||arr[i].equals("-")||arr[i].equals("/")||arr[i].equals("*"))
            {
                int temp1=s.pop();
                int temp2=s.pop();
                int out=0;
                if(arr[i].equals("+"))
                 out=temp1+temp2;
                 else if(arr[i].equals("-"))
                 {
                     out=temp2-temp1;
                 }
                 else if(arr[i].equals("/"))
                 {
                     out=temp2/temp1;
                 }
                 else if(arr[i].equals("*"))
                 {
                     out=temp1*temp2;
                 }
                 s.add(out);
            }
            else{
                int a=Integer.valueOf(arr[i]);
                s.add(a);
            }
        }
        return s.peek();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends