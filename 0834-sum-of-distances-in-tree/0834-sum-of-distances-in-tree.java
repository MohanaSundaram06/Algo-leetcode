class Solution {
    
    public void constructGraph( ArrayList<ArrayList<Integer>> graph, int n, int[][] edges){
        
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int count[] = new int[n];
        int[] distance = new int[n];
        
        Arrays.fill(count, 1);
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        constructGraph(graph,n, edges);
        
        postOrder(0, -1,count, distance, graph);
        preOrder(0, -1, count, distance, graph);
        
        return distance;
       
    }
    
    public void postOrder(int src, int parent, int[] count, int[] distance,ArrayList<ArrayList<Integer>> graph ){
        
        for(int nbr : graph.get(src)){
            if(nbr != parent){
                postOrder(nbr, src, count, distance, graph);
                count[src] += count[nbr];
                distance[src] += distance[nbr] + count[nbr];
            }
        }
    }
    
    public void preOrder(int src, int parent, int[] count, int[] distance,ArrayList<ArrayList<Integer>> graph ){
        
        for(int nbr : graph.get(src)){
            if(nbr !=  parent){          
                distance[nbr] = count.length - count[nbr] + distance[src] - count[nbr];
                preOrder(nbr, src, count, distance, graph);
               
            }
        }
    }
}






















