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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversar(list , root);
        return list;
    }

    public void traversar(List<Integer> list , TreeNode cur){
        if(cur==null){
            return;
        }
        traversar(list,cur.left);
        traversar(list,cur.right);
        list.add(cur.val);
    }
}