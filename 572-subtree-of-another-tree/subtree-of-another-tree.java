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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return findSubtree(root,subRoot);
    }

    // finds the starting of subRoot in root and verifies if they are same using isSame() method
    public boolean findSubtree(TreeNode root , TreeNode subRoot){
        if(root==null){
            return false;
        }
        if(root.val == subRoot.val){
            if(isSame(root,subRoot)){
                return true;
            }
        }
        return (findSubtree(root.left , subRoot) || findSubtree(root.right , subRoot));
    }

    //checks if current subtree is same or not 
    public boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val==q.val){
            return (isSame(p.left , q.left) && isSame(p.right , q.right));
        }
        return false;
    }
}