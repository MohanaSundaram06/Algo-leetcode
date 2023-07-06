class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a,b) -> {
            if(a[0] < b[0]) return -1;
            return 1;
            });
        
        int end = points[0][1];
        
        int count = 1;
        
        for(int i = 1; i < points.length; i++){
            int start = points[i][0];
            int currEnd = points[i][1];
           
            if(start > end){
                count++;
                end = currEnd;
            }
            else{
                end = Math.min(end, currEnd);
            }
        }
        return count;
    }
}