class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int ans  = 0;
        int n  = customers.length;
        
        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0){
                ans += customers[i];
                customers[i] = 0;
            }
        }
        int temp = 0;
        int grump = 0;
        for(int right = 0; right < n; right ++){
          
            grump += customers[right];
            
            if(right - minutes>= 0) grump -= customers[right - minutes];
            
            temp = Math.max(temp ,grump );
            
        }
        
        return ans + temp;
    }
}