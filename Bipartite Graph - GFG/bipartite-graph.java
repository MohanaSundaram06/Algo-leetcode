//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean[] visited = new boolean[V];
        int[] colour = new int[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(i, 0, adj, visited, colour)) return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int src, int clr, ArrayList<ArrayList<Integer>>adj,boolean[] visited, int[] colour ){
        
        visited[src] = true;
        colour[src] = clr;
        
        int nbrClr = clr == 0 ? 1 : 0;
        
        for(int nbr : adj.get(src)){
            if(!visited[nbr]) {
                if(dfs(nbr, nbrClr, adj, visited, colour)) return true;
            }
            
            else if( colour[nbr] == colour[src]) return true;
        }
        
        return false;
    }
}