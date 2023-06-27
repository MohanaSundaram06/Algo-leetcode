class Solution {
    
    public void findprevSmallIndex(int[] heights, int[] index){
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = heights.length - 1; i >=0 ; i--){
            
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                index[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty())  index[st.pop()] = -1;
    }
    
    public void findnextSmallIndex(int[] heights, int[] index){
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < heights.length ; i++){
            
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                index[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty())  index[st.pop()] = heights.length;
    }
    
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        
        int[] prevSmallIndex = new int[n];
        
        int[] nextSmallIndex = new int[n]; 
        
        findprevSmallIndex(heights,prevSmallIndex);
        findnextSmallIndex(heights,nextSmallIndex);
        
        int max = 0;
        
        for(int i = 0; i < n; i++){
            int height = heights[i];
            
            int breadth = nextSmallIndex[i] - prevSmallIndex[i] - 1;
            
            max = Math.max(max, height * breadth);
        }
        
        return max;
    }
}