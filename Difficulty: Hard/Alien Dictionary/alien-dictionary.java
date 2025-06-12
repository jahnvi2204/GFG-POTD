import java.util.*;

class Solution {
    public String findOrder(String[] words) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        
        Set<Character> usedChars = new HashSet<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                usedChars.add(c);
            }
        }
        
        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int j=0;
            while(j<Math.min(s2.length(),s1.length())){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
                j++;
            }
            if(j == s2.length() && j < s1.length()) {
                return "";  
            }        
        } 
        
        List<Integer> result = topoSort(adj, usedChars);
        if(result.isEmpty()) return "";
        
        String ans = "";
        for(int i : result){
            char c = (char)(i + 'a');
            if(usedChars.contains(c)) {
                ans += c;
            }
        }
        return ans;
    } 
        
    public static List<Integer> topoSort(List<List<Integer>> adj, Set<Character> usedChars) {
        int[] indegree = new int[26];
        
        for(int i = 0; i < 26; i++) {
            if(usedChars.contains((char)(i + 'a'))) {
                for(int neighbor : adj.get(i)) {
                    if(usedChars.contains((char)(neighbor + 'a'))) {
                        indegree[neighbor]++;
                    }
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < 26; i++) {
            if(usedChars.contains((char)(i + 'a')) && indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            
            for(int neighbor : adj.get(node)) {
                if(usedChars.contains((char)(neighbor + 'a'))) {
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        int expectedCount = usedChars.size();
        return result.size() == expectedCount ? result : new ArrayList<>();
    }
}