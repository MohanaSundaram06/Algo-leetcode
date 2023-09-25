class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        
        long sum = 0;
        
        int n = maxHeights.size();
        
        for(int i = 0; i < n; i++){
            sum = Math.max( sum, helper(maxHeights,i));
        }
        
        return sum;
    }
    
    public long helper(List<Integer> maxHeights, int idx ){
        long sum = 0;
        int n = maxHeights.size();
        int peek = maxHeights.get(idx);
        
        int min = peek;
        
        if( idx + 1 < n){     
            for(int i = idx + 1; i < n; i++) {
                min = Math.min(min, maxHeights.get(i));
                sum +=  min;
            }
        }
        
        min = peek;
        
        if( idx - 1 >= 0){     
            for(int i = idx - 1; i >= 0; i--) {
                min = Math.min(min, maxHeights.get(i));
                sum +=  min;
            }
        }
        
        return sum + peek;
    }
}