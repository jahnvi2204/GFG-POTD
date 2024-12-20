//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
          ArrayList<Integer> list = new ArrayList<Integer>();
        int r=mat.length , c = mat[0].length;
        int top = 0 , down = r-1 , left = 0 , right = c-1 , d = 0;
        while(top<=down && left<=right){
            switch(d){
                case 0:
                    for(int i=left ; i<=right ; i++){
                        list.add(mat[top][i]);
                    }
                    top++;
                    break;
                case 1 :
                    for(int i=top;i<=down;i++){
                        list.add(mat[i][right]);
                    }
                    right--;
                    break;
                case 2:    
                    for(int i=right ; i>=left ;i--){
                        list.add(mat[down][i]);
                    }
                    down--;
                    break;
                case 3:
                    for(int i=down;i>=top;i--){
                        list.add(mat[i][left]);
                    }
                    left++;
                    break;
            }
            if(d==3)
            d=0;
            else
            d++;
        }
        return list;
    }
}
