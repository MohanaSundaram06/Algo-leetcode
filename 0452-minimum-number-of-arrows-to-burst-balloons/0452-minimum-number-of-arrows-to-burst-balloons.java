class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a,b) -> {
            
            if(a[0] < b[0]) return - 1;
            
            else if(a[0] > b[0]) return 1;
            
            return 0;
        });
        
        int count = 1;
        
        int end = points[0][1];
        
        int n = points.length;
        
        for(int i = 0; i < n; i++){
            
            int a = points[i][0];
            int b = points[i][1];
            
            // overlaps
            if(a <= end){
                end = Math.min(end, b);
            }
            else{
                count++;
                end = b;
            }
        }
        
        return count;
    }
}