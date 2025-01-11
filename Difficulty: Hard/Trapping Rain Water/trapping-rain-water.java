//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int height[]) {
        // code here
    int low=0;
        int high=height.length-1;
        int left=height[low];
        int right=height[high];
        int sum=0;
        while(low<high){
            if(left<right){
                low++;
                left=Math.max(left,height[low]);
                sum+=left-height[low];
            }
            else{
                high--;
                right=Math.max(right,height[high]);
                sum+=right-height[high];
            }
        }
        return sum;
    }
}