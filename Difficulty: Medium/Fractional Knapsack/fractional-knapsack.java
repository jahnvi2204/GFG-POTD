//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Solution {
    double fractionalKnapsack(List<Integer> values, List<Integer> weights, int capacity) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            items.add(new Item(values.get(i), weights.get(i)));
        }

        items.sort((a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double maxValue = 0.0; 
        for (Item item : items) {
            if (capacity >= item.weight) {
                
                maxValue += item.value;
                capacity -= item.weight;
            } else {
              
                maxValue += (double) item.value * capacity / item.weight;
                break; 
            }
        }

        return maxValue;
    }
}
