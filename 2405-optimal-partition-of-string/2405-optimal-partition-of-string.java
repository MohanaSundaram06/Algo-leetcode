class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 1;
        
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){
                set.clear();
                ans++;
            }
            set.add(ch);
        }
        return ans;
    }
}