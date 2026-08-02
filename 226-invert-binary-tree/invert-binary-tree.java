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
    public TreeNode invertTree(TreeNode root) {
        return invert(root);   
    }

    public TreeNode invert(TreeNode cur){
        if(cur==null){
            return null;
        }
        TreeNode l = invert(cur.right);
        TreeNode r = invert(cur.left);
        cur.left = l;
        cur.right = r;
        return cur;
    }
}