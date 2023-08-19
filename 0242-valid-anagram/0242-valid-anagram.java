class Solution {
    public boolean isAnagram(String s, String t) {
        
       if(s.length() != t.length()) return false;
        
        int[] arr = new int[26];
        
        for(char str : s.toCharArray() ) arr[str - 'a']++;
        
        for(char str : t.toCharArray() ) arr[str - 'a']--;
        
        for(int i : arr) {
            if(i != 0) return false;
        }
        return true;
        
    }
}