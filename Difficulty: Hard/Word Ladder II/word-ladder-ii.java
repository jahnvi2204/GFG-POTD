// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        
        Set<String> set = new HashSet<>();
        int ln = wordList.length;
        for(int i=0;i<ln;i++){
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        ArrayList<String> uol = new ArrayList<>();
        uol.add(startWord);
        int lvl = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ArrayList<String> vec = q.peek();
            q.remove();
            if(vec.size()>lvl){
                lvl++;
                for(String it : uol){
                    set.remove(it);
                    
                }
            }
            String w = vec.get(vec.size()-1);
            if(w.equals(targetWord)){
                if(ans.size()==0) ans.add(vec);
                else if (ans.get(0).size()==vec.size()){
                    ans.add(vec);
                }
            }
             for(int i = 0; i < w.length(); i++) {
                
                for(char c = 'a'; c <= 'z'; c++) {
                 char[] chars = w.toCharArray();
                     chars[i]=c;
                     String repWord =  new String(chars);
                     if(set.contains(repWord)){
                         vec.add(repWord);
                         ArrayList<String> temp = new ArrayList<>(vec);
                         
                         q.add(temp);
                         uol.add(repWord);
                         vec.remove(vec.size()-1);
                         
                     }

               }
             }
        }
        return ans;
        
    
}
}