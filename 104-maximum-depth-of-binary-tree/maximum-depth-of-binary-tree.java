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
    public int maxDepth(TreeNode root) {
        return digger(root , 1);
    }

    public int digger(TreeNode cur , int level){
        if(cur==null){
            return level-1;
        }
        int l = digger(cur.left , level+1);
        int r = digger(cur.right , level+1);
        return Math.max(l,r);
    }
}