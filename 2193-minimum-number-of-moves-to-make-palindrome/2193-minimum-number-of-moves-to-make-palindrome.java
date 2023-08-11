class Solution {
    
    public void swap(char[] arr, int a, int b){
        
        char ch = arr[a];
        arr[a] = arr[b];
        arr[b] = ch;
        // System.out.println(Arrays.toString(arr));
    }
    
    public int minMovesToMakePalindrome(String s) {
        
        int start = 0;
        int end  = s.length() - 1;
        
        int swaps = 0;
        
        char[]  arr = s.toCharArray();
        
        while( start < end){
            
            if(arr[start] == arr[end]) {start ++; end--; continue;}
               
                
            int k = end;

            while(arr[start] != arr[k]) k--;
            
            if(start == k){
                swap(arr, start, start + 1);
                swaps++;
            }
            else{
                while(k < end){
                    swap(arr, k, k + 1);
                    k++;
                    swaps++;
                }
            }
            
        }
        
        return swaps;
        
    }
}