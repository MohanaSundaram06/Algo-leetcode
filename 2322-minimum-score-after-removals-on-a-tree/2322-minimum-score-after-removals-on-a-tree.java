class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        boolean[][] ancestor = new boolean[n][n];
        int[] xorArray = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        dfs(0, -1, graph, nums, ancestor);
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 1; i < n; i++){
            for(int j = i + 1; j < n; j++){
                
                int a = 0, b = 0, c = 0;
                
                if (i == j) continue;
                
                if(ancestor[i][j]){
                    a = nums[j];
                    b = nums[i] ^ a;
                    c = nums[0] ^ a ^ b;
                }
                else if(ancestor[j][i]){
                    a = nums[i];
                    b = nums[j] ^ a;
                    c = nums[0] ^ a ^ b;
                }
                else{
                    a = nums[i];
                    b = nums[j];
                    c = nums[0] ^ a ^ b;
                }
                
                ans = Math.min( ans , Math.max(a,Math.max(b, c)) - Math.min(a, Math.min(b,c)));
            }
        }
        
        return ans;
        
        
    }
    
    public void dfs(int src, int parent, ArrayList<ArrayList<Integer>> graph, int[] nums,  boolean[][] ancestor){
        
        setAncestor(src, parent, src, graph, ancestor);
        
        for(int child : graph.get(src)){
            
            if(child == parent) continue;
            
            dfs(child, src, graph, nums, ancestor);           
            nums[src] ^= nums[child];
        }
    }
    
    public void setAncestor(int src, int parent, int root, ArrayList<ArrayList<Integer>> graph, boolean[][] ancestor){
        ancestor[root][src] = true;
        
        for(int child : graph.get(src)){
            
           if(child == parent) continue;
            
           setAncestor(child, src, root, graph, ancestor);
        }
        
    }
}


















