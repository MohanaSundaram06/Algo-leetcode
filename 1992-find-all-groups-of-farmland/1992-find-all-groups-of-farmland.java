class Solution {
    int row = 0;
    int col = 0;
    public int[][] findFarmland(int[][] land) {
        
        ArrayList<int[]> arr = new ArrayList<>();
        
        int r = land.length;
        int c =  land[0].length;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(land[i][j] == 1){
                    dfs(i,j, land);
                    arr.add(new int[]{i,j,row, col});
                    row = 0;
                    col = 0;
                }
            }
        }
        int[][] result = new int[arr.size()][4];
        for(int i = 0 ; i < arr.size(); i++){
            result[i] = arr.get(i);
        }
        
        return result;
    }
    
    public void dfs(int i, int j, int[][] land){
    
        
        if(i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] == 0) return;
        
        row = Math.max(row, i);
        col = Math.max(col, j);
        
        land[i][j] = 0;
        
        dfs(i + 1, j, land);
        dfs(i, j + 1, land);
        
        return;
        
    }
}








