

class Solution {
    class Pair{
        String first;
        int second;
        Pair(String first, int second){  
            this.first = first;
            this.second = second;
        }
    }
    
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        HashSet<String> wordSet = new HashSet<>();
        for(String s : wordList){
            wordSet.add(s);
        }
        
        if(!wordSet.contains(targetWord)) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();  
        
        q.add(new Pair(startWord, 1));  
        visited.add(startWord);
        
        while(!q.isEmpty()){
            Pair current = q.poll();
            String word = current.first;
            int length = current.second;
            
            if(word.equals(targetWord)) {
                return length;
            }
            
            for(int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                
                for(char c = 'a'; c <= 'z'; c++) {
                    if(c == chars[i]) continue;  
                    
                    chars[i] = c;
                    String newWord = new String(chars);
                    
                    if(wordSet.contains(newWord) && !visited.contains(newWord)) {
                        visited.add(newWord);
                        q.add(new Pair(newWord, length + 1));
                    }
                }
            }
        }
        
        return 0;  
    }
}