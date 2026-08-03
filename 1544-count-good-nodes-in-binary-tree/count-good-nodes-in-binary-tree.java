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
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int maxSoFar = root.val;
        TreeNode cur = root;
        return goodFinder( cur , maxSoFar);
    }

    public int goodFinder(TreeNode cur , int maxSoFar){
        if(cur==null){
            return 0;
        }
        boolean isGood = false;
        if(cur.val >= maxSoFar){
            isGood = true;
            maxSoFar = cur.val;
        }
        return goodFinder(cur.left , maxSoFar) + goodFinder(cur.right , maxSoFar) + (isGood ? 1 : 0);
    }
}