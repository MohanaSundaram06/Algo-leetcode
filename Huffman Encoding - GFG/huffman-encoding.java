//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Pair{
    char c ;
    int num;
    Pair left;
    Pair right;
    
    Pair(char c, int num){
        this.c = c;
        this.num = num;
    }
}
class Solution {
    
    public void dfs(Pair root,  ArrayList<String> ans, String psf){
        
        // if(root == null) return;
        
        if(root.left == null && root.right == null){
            ans.add(psf);
            return;
        }
        
        dfs(root.left, ans, psf + "0");
        dfs(root.right, ans, psf + "1");
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> {
            
            return a.num < b.num ? -1 : 1;
        });
        
        for(int i = 0; i < N; i++) pq.add(new Pair(S.charAt(i), f[i]));
        
        while(pq.size() > 1){
            
            Pair p1 = pq.remove();
            Pair p2 = pq.remove();
            
            Pair temp = new Pair('.', p1.num + p2.num );
            
            temp.left = p1;
            temp.right = p2;
            
            pq.add(temp);
            
        }
        
        ArrayList<String> ans = new ArrayList<>();
        dfs(pq.peek(), ans, "");
        
        return ans;
    }
}