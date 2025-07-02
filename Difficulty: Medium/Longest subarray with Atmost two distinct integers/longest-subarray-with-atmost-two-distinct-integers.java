   
   class Solution{ public int totalElements(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0 , end = 0 , start = 0;
        while(end < arr.length){
            map.put(arr[end] , map.getOrDefault(arr[end] , 0) + 1);
            while(map.size() > 2){
              map.put(arr[start] , map.getOrDefault(arr[start] , 0) - 1);
              if(map.get(arr[start]) == 0)
                map.remove(arr[start]);
                start++;
            }
            ans = Math.max(ans , (end - start + 1));
            end++;
        }
        return ans;
    }
}