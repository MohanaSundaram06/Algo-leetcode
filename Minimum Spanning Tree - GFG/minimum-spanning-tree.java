//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class DSU{
    int[] parent;
    int[] size;
    
    DSU(int V){
        parent = new int[V];
        size = new int[V];
        
        for(int i = 0; i < V; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    int findParent(int a){
        if(parent[a] == a){
            return a;
        }
        
        return  findParent(parent[a]);
    }
    
    boolean union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a != b){
            if(size[a] < size[b]){
                parent[a] = b;
                size[b] += size[a];
            }
            else{
                parent[b] = a;
                size[a] += size[b];
            }
            return true;
        }
        return false;
       
    }
}

class Edge implements Comparable<Edge>{
    
    int src,dst, wt;
    
    Edge(int src, int dst, int wt){
        this.src = src;
        this.dst = dst;
        this.wt = wt;
    }
    @Override
    public int compareTo(Edge e){
        return this.wt - e.wt;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<Edge> graph = new ArrayList<>();
	    
	    for(int[] e : edges){
	        graph.add(new Edge(e[0], e[1], e[2]));
	    }
	    
	    Collections.sort(graph);
	    
	    DSU d = new DSU(V);
	    
	    int ans = 0;
	    
	    for( Edge e : graph){
	        
	        if( d.union(e.src, e.dst)){
	           
	            ans += e.wt;
	        }
	    }
	    
	    return ans;
	}
}


























