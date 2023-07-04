class Solution {
    int time = 0;
    
    public void constructGraph(int n, List<List<Integer>> connections, ArrayList<ArrayList<Integer>> graph ){
        
        for(int i =0 ; i < n; i++) graph.add(new ArrayList<>());
        
        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
        
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        constructGraph(n, connections, graph);
        
        List<List<Integer>> bridge = new ArrayList<>();
        
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] low = new int[n];
        
        dfs(0, -1, bridge, dist, low, visited, graph);
        
        return bridge;
        
    }
    
    public void dfs(int src, int parent, List<List<Integer>> bridge, int[] dist, int[] low,
                    boolean[] visited, ArrayList<ArrayList<Integer>> graph ){
        
        visited[src] = true;
        low[src] = dist[src] = time;
        time ++;
        
        for(int nbr : graph.get(src)){
            
            if(nbr == parent) continue;
            
            if(!visited[nbr]){
                
                dfs(nbr, src, bridge, dist, low, visited, graph);
                
                low[src] = Math.min(low[src], low[nbr]);
                
                if(dist[src] < low[nbr]) bridge.add(Arrays.asList(src,nbr));
            }
            else{
                low[src] = Math.min(low[src], dist[nbr]);
            }
        }
    }
}























