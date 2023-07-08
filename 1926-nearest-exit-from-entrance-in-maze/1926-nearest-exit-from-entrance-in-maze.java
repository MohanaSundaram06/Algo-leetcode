class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{entrance[0],entrance[1]});
        
        int count = 0;
        
        int r = maze.length;
        int c= maze[0].length;
        
        boolean[][] visited = new boolean[r][c];
        visited[entrance[0]][entrance[1]] = true;
        
        int[][] dir = new int[][] {{0,1}, {0, -1}, { 1, 0}, {-1, 0}};
        
        while( q.size() > 0){
            int size= q.size();
            count++;
            while( size > 0){
                
                int[] pos = q.remove();
                
                size--;
                
                for(int i = 0; i < 4; i++){
                    int x = pos[0] + dir[i][0];
                    int y = pos[1] + dir[i][1];
                    
                    if( x < 0 || y < 0 || x >= r || y >= c || visited[x][y] || maze[x][y] == '+') continue;
                    
                    if(x== 0 || y == 0 || x == r - 1 || y == c - 1) return count;
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        
        return -1;
    }
}
























