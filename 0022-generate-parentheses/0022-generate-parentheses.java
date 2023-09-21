class Solution {
    public void generate(int open, int close, int n, String str, List<String> parenthesis ){
        
        if(open == n && close == n) {
            parenthesis.add(str);
            return;
        }
        
        if(open < n) generate(open + 1, close, n, str + "(", parenthesis);
        
        if(close < n && open > close) generate(open, close + 1, n, str + ")", parenthesis);
        
    }
    public List<String> generateParenthesis(int n) {
        
        List<String> parenthesis = new ArrayList<>();
        generate(0,0,n,"",parenthesis);
        
        return parenthesis;
    }
}