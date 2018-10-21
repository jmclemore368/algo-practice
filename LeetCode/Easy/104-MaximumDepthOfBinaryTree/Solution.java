/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int numNodesLeft = maxDepth(root.left);
        int numNodesRight = maxDepth(root.right);
        int maxOfLeftAndRight = Math.max(numNodesLeft, numNodesRight);
        return maxOfLeftAndRight + 1;
    }
}
