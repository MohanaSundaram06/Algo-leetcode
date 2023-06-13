class Solution {
    public int maxPoints(int[][] points) {
        
        int ans = 0;
        int n = points.length;
        HashMap<Double,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i ++ ){
            map.clear();
            for(int j = 0; j < n; j++){
                
                if(i == j) continue;
                
                double slope = findSlope(points[i],points[j]);
                
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                
                ans = Math.max(ans, map.get(slope));
            }
        }
        return ans + 1;
    }
    
    public double findSlope(int[] x, int[] y){
        
        if(x[0] == y[0]) return Double.MAX_VALUE;
        
        if(x[1] == y[1]) return 0;
        
        return (double)(y[1] - x[1]) / (double)(y[0] - x[0]);
    }
}