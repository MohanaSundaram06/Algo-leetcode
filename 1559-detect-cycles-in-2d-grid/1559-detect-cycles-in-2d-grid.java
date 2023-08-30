class Solution {
    
    int[][] dir = { {0,1}, {1,0}, {0, -1}, {-1, 0}};
    
    public boolean containsCycle(char[][] grid) {
        
        int r = grid.length;
        int c = grid[0].length;
        
        boolean[][] visited = new boolean[r][c];
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                
                if(visited[i][j]) continue;
                
                if(dfs(i, j, grid[i][j],grid, visited, - 1, -1)) return true;
            }
        }
        
        return false;
    }
    
    
    public boolean dfs(int r, int c, char ch, char[][] grid, boolean[][] visited,int pr, int pc){
        
        visited[r][c] = true;
        
        for(int i = 0; i < 4; i++){
            
            int cr = r + dir[i][0];
            int cc = c + dir[i][1];
            
            if(cr < 0 || cr >= grid.length || cc < 0 || cc >= grid[0].length || grid[cr][cc] != ch ) continue;
            
            if(pr == cr && pc == cc) continue;
            
            if(visited[cr][cc]) return true;
            
            if(dfs(cr, cc, ch, grid, visited, r, c)) return true;
        }
        
        return false;
        
    }
}





















