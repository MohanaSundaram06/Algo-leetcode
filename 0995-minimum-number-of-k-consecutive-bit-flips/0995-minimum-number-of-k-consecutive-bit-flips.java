class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flips = 0;
        int activeFlips = 0;
        
        int n = nums.length;
        
        boolean[] pointers = new boolean[n];
        
        for(int i = 0; i < n; i++){
            
            if((nums[i] == 0 && activeFlips % 2 == 0) || (nums[i] == 1 && activeFlips % 2 != 0)){
                
                flips++;
                activeFlips++;
                
                if( i + k - 1 >= n  ) return -1;
                
                pointers[i + k - 1] = true;;
            }
            if(pointers[i]) {
                activeFlips --;
            }
            
        }
        return flips;
    }
}