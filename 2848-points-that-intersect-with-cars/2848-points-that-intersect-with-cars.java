class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        
        int[] array = new int[102];
        
        int count = 0;
        
        for(List<Integer> points : nums){        
            
            array[points.get(0)]++;

            array[points.get(1) + 1]--; //marking endpoint + 1 because car will be present at the end point;
        }
        
        int sum = 0;
        for(int i : array){
            sum += i;          
            if( sum  > 0) count++;
        }
        
        return count;
    }
}