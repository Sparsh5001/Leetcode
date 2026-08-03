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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curLevel = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(root);
        levelNodes.offer(null);
        curLevel.add(root.val);
        ans.add(new ArrayList<>(curLevel));
        levelOrderTraversal(ans,levelNodes);
        return ans;
    }

    public void levelOrderTraversal(List<List<Integer>> ans , Queue<TreeNode> levelNodes){
        List<Integer> curLevel = new ArrayList<>();
        while(!levelNodes.isEmpty()){
            if(levelNodes.peek()==null){
                if(curLevel.size()==0){
                    return;
                }
                ans.add(new ArrayList<>(curLevel));
                curLevel.clear();
                levelNodes.poll();
                if(levelNodes.isEmpty()){
                    return;
                }
                levelNodes.offer(null);
            }
            if(levelNodes.peek().left != null){
                curLevel.add(levelNodes.peek().left.val);
                levelNodes.offer(levelNodes.peek().left);
            }
            if(levelNodes.peek().right != null){
                curLevel.add(levelNodes.peek().right.val);
                levelNodes.offer(levelNodes.peek().right);
            }
            levelNodes.poll();
        }
    }
}