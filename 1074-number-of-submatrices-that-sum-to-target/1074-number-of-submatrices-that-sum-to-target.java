class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        for(int i = 0; i < r; i++){
            for(int j = 1; j < c; j++){
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        int count = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < c; i ++){
            for(int j = i; j < c; j++){
                
                int sum = 0;
                map.clear();
                map.put(0, 1);
                for(int t = 0; t < r; t++){
                    sum += matrix[t][j];
                    int temp = i - 1 >= 0 ? matrix[t][i - 1] : 0;
                    sum -= temp;
                    if(map.containsKey(sum - target)){
                        count += map.get(sum - target);
                    }
                    map.put(sum , map.getOrDefault(sum, 0) + 1);
                }
            }
        }    
        return count;
    }
}











