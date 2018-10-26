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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Let t1 be the new merged tree
        if (t1 == null && t2 == null) {
            return null;
        }
        else if (t1 == null && t2 != null) {
            t1 = t2;
        } else if (t1 != null && t2 == null) {
            // Since we return t1, don't need to do anything
        } else {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }
        return t1;
    }
}
