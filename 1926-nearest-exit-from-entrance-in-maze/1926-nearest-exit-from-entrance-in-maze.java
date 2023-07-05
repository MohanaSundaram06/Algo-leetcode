class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        Queue<int[]> q = new LinkedList<>();
        
        int r = maze.length;
        int c = maze[0].length;
        
        q.add(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';

        int ans = 0;
        
        int[][] dir = new int[][] {{0,1} , {0,-1}, {1,0}, {-1,0}};
        
        while(q.size() > 0){
            int size = q.size();
            ans ++;
            while( size > 0){
                
                int[] p = q.remove();
                size --;
                         
                for(int i = 0; i < 4; i++){
                    int x = p[0] + dir[i][0];
                    int y = p[1] + dir[i][1];

                    if( x < 0 || y < 0 || x >= r || y >= c || maze[x][y] == '+') continue;
                    
                    if(x == 0 || y == 0 || x == r - 1 || y == c - 1) return ans;
                    q.add(new int[]{x, y});
                    maze[x][y] = '+';

                }
            }
             
        }
        
        return -1;
        
    }
}

















