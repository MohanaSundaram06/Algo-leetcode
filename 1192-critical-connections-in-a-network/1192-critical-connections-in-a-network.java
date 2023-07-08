class Solution {
    public int time;
    
    public void constructGraph( ArrayList<ArrayList<Integer>> graph,int n, List<List<Integer>> connections ){
        
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);
            
            graph.get(u).add(v);
            graph.get(v).add(u);
            
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        int[] dist = new int[n];
        int[] lowDist = new int[n];
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        constructGraph(graph, n, connections);
        
        boolean[] visited = new boolean[n];
        
        List<List<Integer>> bridge = new ArrayList<>();
        
        dfs( 0,  -1, dist, lowDist, graph, bridge, visited);
        
        return bridge;
    }
    
    public void dfs(int src, int parent , int[]  dist, int[] low ,  
                    ArrayList<ArrayList<Integer>> graph, List<List<Integer>> bridge, boolean[] visited){
        
        dist[src] = low[src] = time;
        time++;
        visited[src] = true;
        
        for(int nbr : graph.get(src)){
            
            if( nbr == parent) continue;
            
            if(!visited[nbr]){             
                dfs(nbr, src, dist, low, graph, bridge, visited);
                
                low[src] = Math.min(low[src], low[nbr]);
                
                if(dist[src] < low[nbr]) bridge.add(Arrays.asList(src,nbr));
                
            }
            else{
                low[src] = Math.min(low[src], dist[nbr]);
            }
        }
    }
}


























