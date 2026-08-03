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
    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevel = 0;

        int xLevel = 0;
        int yLevel = 0;
        TreeNode xParent = null;
        TreeNode yParent = null;
        boolean xfound=false;
        boolean yfound=false;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();
                
                if (current.left != null) {
                    if(current.left.val==x){
                        xLevel=curLevel+1;
                        xParent = current;
                        xfound = true;
                    }
                    if(current.left.val==y){
                        yLevel=curLevel+1;
                        yParent = current;
                        yfound = true;
                    }
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    if(current.right.val==x){
                        xLevel=curLevel+1;
                        xParent = current;
                        xfound = true;
                    }
                    if(current.right.val==y){
                        yLevel=curLevel+1;
                        yParent = current;
                        yfound = true;
                    }
                    queue.offer(current.right);
                }
            }
            if(xfound && yfound){
                if(yLevel==xLevel && yParent!=xParent){
                    return true;
                }return false;
            }
            curLevel++;
        }
        return false;
    }
}