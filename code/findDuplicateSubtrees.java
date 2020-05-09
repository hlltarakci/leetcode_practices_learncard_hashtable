// https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1127/

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
    /*
        n: node count
        time: O(n)
        space: O(n)
    */
    Map<String, List<TreeNode>> map = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        visitTree(root);
        
        List<TreeNode> duplicates = new ArrayList<>();
        for(List<TreeNode> value: map.values()) {
            if(value.size() > 1) duplicates.add(value.get(0));
        }
        
        return duplicates;
    }
    
    private String visitTree(TreeNode root) {
        if(root == null) return "";
        
        String key = "";
        if(root.left == null && root.right == null) {
            key = "" + root.val;
        } else {
            String leftKey = visitTree(root.left);
            String rightKey = visitTree(root.right);

            key =root.val + "L" + leftKey + "R" + rightKey;
        }
    
        List<TreeNode> value = map.getOrDefault(key, new ArrayList<>());
        value.add(root);
        map.put(key, value);
        return key;
    }
}
