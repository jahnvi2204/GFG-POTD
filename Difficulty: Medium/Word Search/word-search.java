//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Directions for adjacent cells: up, down, left, right
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    // Function to check if the word exists in the matrix
    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        // Loop through each cell of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the first character matches, start DFS
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // DFS function to search for the word
    private static boolean dfs(char[][] mat, String word, int x, int y, int index) {
        // If all characters are found
        if (index == word.length()) {
            return true;
        }

        // If out of bounds or the current character does not match
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark this cell as visited by replacing it with a special character
        char temp = mat[x][y];
        mat[x][y] = '#';

        // Explore all four possible directions
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (dfs(mat, word, newX, newY, index + 1)) {
                return true;
            }
        }

        // Backtrack: unmark the cell
        mat[x][y] = temp;

        return false;
    }}