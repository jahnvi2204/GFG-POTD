//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
       ArrayList<String> array = new ArrayList<>();
        for (String s : arr) array.add(s);
          ArrayList<ArrayList<String>> list = new ArrayList<>();
        while (!array.isEmpty()) {
            ArrayList<String> l = new ArrayList<>();
            int n=array.size();
            for (int i = 0; i < n ;i++) {
                if (l.isEmpty()) {
                    l.add(array.get(i));
                } else {
                    if (areAnagram(l.get(0), array.get(i))) {
                        l.add(array.get(i));
                    }
                }
            }
            for(String s:l) array.remove(s);
            list.add(l);
        }
        return list;
    }
    
   public boolean areAnagram(String S1, String S2) {
        char ch[] = S1.toCharArray();
        char ch1[] = S2.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch1);
        if (Arrays.equals(ch, ch1)) {
            return true;
        } else return false;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends