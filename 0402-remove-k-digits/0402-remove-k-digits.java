class Solution {
    public String removeKdigits(String num, int k) {
        
        if(k == num.length()) return "0";
        Stack<Character> st = new Stack<>();
        
        for(char ch : num.toCharArray()){
            
            while(!st.isEmpty() && st.peek() > ch && k  > 0){
                st.pop();
                k--;
            }
            
            st.push(ch);
        }
        
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        
        StringBuilder sb  = new StringBuilder();
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        
        while(sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
        
        return sb.toString();
    }
}