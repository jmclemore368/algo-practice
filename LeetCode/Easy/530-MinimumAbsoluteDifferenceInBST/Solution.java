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
    public int getMinimumDifference(TreeNode root) {
        // In-order traversal gives BST increasing order
        List<Integer> inOrder = new LinkedList<>();
        inOrderTraversal(root, inOrder);

        // Find minimum difference of adjacent elements
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < inOrder.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(inOrder.get(i) - inOrder.get(i - 1)));
        }

        return minDiff;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> l) {
        if (root != null) {
            inOrderTraversal(root.left, l);
            l.add(root.val);
            inOrderTraversal(root.right, l);
        }
    }
}
