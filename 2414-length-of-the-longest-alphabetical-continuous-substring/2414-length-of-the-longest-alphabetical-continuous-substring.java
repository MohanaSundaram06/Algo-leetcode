class Solution {
    public int longestContinuousSubstring(String s) {
        
        int ans = 1;
        int lp = 0;
        int rp = 1;
        
        while(rp < s.length()){
            
            if(s.charAt(rp - 1) - 'a'  != s.charAt(rp) -'a'  - 1){
                System.out.println(lp +" " + rp);
                lp = rp;
            }
            ans = Math.max(ans, rp - lp + 1);
            rp++;
        }
        return ans;
    }
}