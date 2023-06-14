//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static void dfs(int[] a, String[] nums, int n, String str, ArrayList<String> comb, int idx ){
        
       
        
        if(str.length() == n){
            comb.add(str);
            return;
        }
        String s = nums[a[idx]];
        
        for(char ch : s.toCharArray()){
            dfs(a, nums, n, str + ch, comb, idx + 1);
        }
    }
    
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        String[] nums = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> comb = new ArrayList<>();
        dfs(a,nums,N,"",comb, 0);
        
        return comb;
    }
}


