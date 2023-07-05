/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair{
    TreeNode node;
    int level;
    
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

class Solution {
    
    public void bulidParentMap(TreeNode root, HashMap<TreeNode,TreeNode> parent ){
        
        if(root == null) return;
        
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);
        
        bulidParentMap(root.left, parent);
        bulidParentMap(root.right, parent);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        
        bulidParentMap(root, parent);
        
        List<Integer> nodes = new ArrayList<>();
        
        
        Queue<Pair> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        q.add(new Pair(target, 0));
        visited.add(target);
        
        while(q.size() > 0){
            
            Pair p = q.remove();
            
            TreeNode node = p.node;
            
            if(p.level == k) nodes.add(node.val);
            
            if(node.left != null && !visited.contains(node.left)) {
                q.add(new Pair(node.left, p.level + 1));
                visited.add(node.left);
            }
            
            if(node.right != null && !visited.contains(node.right)) {
                q.add(new Pair(node.right, p.level + 1));
                visited.add(node.right);
            }
            
            if(parent.containsKey(node) && !visited.contains(parent.get(node))){
                q.add(new Pair(parent.get(node), p.level + 1));
                visited.add(parent.get(node));                 
            }
                    
        }
        
        return nodes;
    }
}



















