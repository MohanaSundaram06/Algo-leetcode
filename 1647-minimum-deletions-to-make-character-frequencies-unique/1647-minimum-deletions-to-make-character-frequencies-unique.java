class Solution {
    public int minDeletions(String s) {
        
        HashMap<Integer,Character> map = new HashMap<>();
        
        int deletions = 0;
        char[] str = s.toCharArray();
        
        Arrays.sort(str);
        
        int n = str.length;
        
        for(int i = 0; i < n; i++){
            
            char ch = str[i];
            
            int freq  = 1;
            
            while( i < n - 1 && ch == str[i + 1]){
                freq++;
                i++;
            }
            while(map.containsKey(freq) && freq > 0){
                deletions++;
                freq --;
            }
            
            if(freq > 0) map.put(freq, ch);
        }
        
        return deletions;
        
    }
}