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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            int size = queue.size();
            if(size%2==1){
                return false;
            }
            for (int i = 0; i < size/2; i++) {
                TreeNode first = queue.poll();
                TreeNode last = queue.poll();
                
                if(first==null && last==null){
                    continue;
                }
                if(first==null || last==null){
                    return false;
                }
                if(first.val != last.val){
                    return false;
                }
                queue.offer(first.left);
                queue.offer(last.right);
                queue.offer(first.right);
                queue.offer(last.left);
            }
        }
        return true;
    }
}