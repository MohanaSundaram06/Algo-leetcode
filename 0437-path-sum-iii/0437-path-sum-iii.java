/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        return dfs(root, 0l, targetSum, map);
    }
    
    public int dfs(TreeNode root, Long sum , int targetSum,HashMap<Long, Integer> map ){
        
        if(root == null) return 0;
        
        sum += root.val;
        int count = 0;
        
        if(map.containsKey(sum - targetSum)) count += map.get(sum - targetSum);
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        count += dfs(root.left , sum ,targetSum, map) + dfs(root.right , sum ,targetSum, map);
        
        map.put(sum, map.get(sum) - 1);
        
        if(map.get(sum) == 0) map.remove(sum);
        
        return count;
    }
}







