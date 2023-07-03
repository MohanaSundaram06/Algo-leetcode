class Pair{
    
    String v ;
    double val;
    
    Pair(String v, double val){
        this.v = v;
        this.val = val;
    }
    @Override
    public String toString(){
        return this.v + " " + this.val;
    }
}

class Solution {
    
    public void contructGraph(List<List<String>> equations, double[] values,  HashMap<String,List<Pair>> graph) {
        
        for(int i = 0; i < values.length; i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            
            graph.putIfAbsent(a,new ArrayList<>());
            graph.putIfAbsent(b,new ArrayList<>());
            
            graph.get(a).add(new Pair(b, value));
            graph.get(b).add(new Pair(a, 1/value));
        }
    }
    
    public double dfs(String src, String dest,  HashMap<String,List<Pair>> graph, HashSet<String> visited){
        
        visited.add(src);
        
        if(src.equals(dest)){ 
            // System.out.print("true");
            return 1.0;
        }
        
        for(Pair nbr : graph.get(src)){
            
            if(!visited.contains(nbr.v)){
                double val = dfs(nbr.v, dest, graph, visited);
                 // System.out.println(val);
                if(val > 0){
                    
                    return nbr.val * val;
                }
            }
        }
        
        return -1.0;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String,List<Pair>> graph = new HashMap<>();
        
        contructGraph(equations, values,graph);
        // System.out.println(graph);
        int n = queries.size();
        
        double[] ans = new double[n];
        HashSet<String> visited = new HashSet<>();

        for(int i = 0; i < n; i++){
            
            visited.clear();
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            
            if(!graph.containsKey(a) || !graph.containsKey(b)){
                ans[i] = -1.0;
                
            }
            else if( graph.containsKey(a) && a.equals(b)) {
                ans[i] = 1.0;
            }
            else if( graph.containsKey(a) && graph.containsKey(b)){
                ans[i] = dfs(a, b, graph, visited);
            }
            else{
                ans[i] = -1.0;
            }
           
        }
        return ans;
        
    }
}

















