//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        
        // Create result array
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(0);
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
            span[i] = i - leftBoundary - 1; 
            stack.push(i);
        }
        
        stack.clear();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            int rightBoundary = stack.isEmpty() ? n : stack.peek();
            span[i] += rightBoundary - i; // Add right contribution to complete the span
            
            int windowSize = span[i];
            result.set(windowSize - 1, Math.max(result.get(windowSize - 1), arr[i]));
            
            stack.push(i);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            result.set(i, Math.max(result.get(i), result.get(i + 1)));
        }
        
        return result;
    }
}