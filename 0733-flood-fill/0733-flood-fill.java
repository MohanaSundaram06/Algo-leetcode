class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color) return image;
        
        dfs(image, sr, sc, image[sr][sc], color);
        
        return image;
        
    }
    
    public void dfs(int[][] image, int sr, int sc,int src, int color){
        
        if(sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || image[sr][sc] != src) return;
        
        image[sr][sc] = color;
        
        dfs(image, sr + 1, sc, src , color);
        dfs(image, sr - 1, sc, src , color);
        dfs(image, sr, sc  + 1, src , color);
        dfs(image, sr , sc - 1, src , color);
    }
}